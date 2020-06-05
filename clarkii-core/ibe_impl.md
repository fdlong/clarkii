# 布尔表达式检索实现

## 算法
布尔表达式有两种比较类型，等值和范围
0. 等值类：=, in
0. 范围类：(a, b), (a, b], [a, b), [a, b]
范围定向需要被分解成'<'，'>'和'='

在实际实现中，采用正反双层索引结构设计
两层正排索引，用以维护定向条件的更新
0. content-conjunction
0. conjunction-assignment

两层倒排索引，用来做内容检索
0. conjunction-content
0. assignment-conjunction

assignment的索引key计算：${attr}
assignment的索引field计算：${comparator}${value}

对于范围类另外维护两个asgin-range-values，用以表示出现过得范围比较
0. '<' 值数组
0. '>' 值数组


## 定向条件维护
当内容的定向条件发生改变时
0. 根据content-conjunction找到该内容的原始定向conjunctions
0. 从原始conjunctions的conjunction-content中将该内容移除
0. 若某conjunction已无内容，可以将该conjunction从此索引中删除
0. 根据conjunction-assignment找到该conjunction的原始定向assignments
0. 从原始assignments的assignment-conjunction中将该内容移除
0. 若某assignment已无conjunction，可以将该assignment从此索引中删除
0. 若为范围类，从attr-values中移除该值


## 内容检索过程
实际检索过程中
0. 通过assignment-conjunction获取conjunctions
0. 当conjunction被命中的次数 hit(conjunction) >= sizeof(conjunction)时，该conjunction定向条件被满足
0. 通过conjunction-content，获取推送内容
0. 若为范围类，从asgin-range-values中查找满足条件的所有values，然后对每个range-value执行第一步

当请求的特征 sizeof(attrs) < sizeof(conjunction)，该conjunction一定不满足要求，可以先利用这个判断减少计算
