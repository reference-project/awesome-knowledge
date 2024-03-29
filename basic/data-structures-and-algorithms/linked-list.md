# 链表(Linked List)

## 经典应用：LRU缓存淘汰算法
链表，说起来链表就逃不过一种链表的经典使用场景，LRU缓存淘汰算法。缓存是我们再熟悉不过的技术了，但因为缓存空间有限，当缓存空间被用满，哪些数据应该被清除出空间，哪些数据应该被保留，这就需要缓存淘汰策略来决定。常见的缓存策略用有三种：先进先出FIFO（First In, First Out），最少使用策略LFU（Least Frequently Used），最近最少使用策略LRU（Least Recently Used）。其中最近最少使用策略LRU（Least Recently Used）的实现就是由链表实现。

## 链表的特点
### 无序
数组是一种有序结构，当我们需要申请一个100M的数组，如果内存中没有足够大的，连续的100M的存储空间，即使内存中剩余的空间大于100M，仍然会申请失败，但链表不会，因为链表是无序的。只要内存空间中剩余的空间大于100M就可以成功的申请下来100M大小的链表。
### 插入快速
假设数组有100个元素，我们在第五十个元素后插入一个元素，那么后面的五十个元素就会相应的挨个后移。但是在链表中，由于链表是无序的，我们只需要随便找一个位置插入，然后在上一个节点的`next`中记录下来这个插入位置。插入操作就变的十分高效。
### 查找缓慢
有利就有弊，链表对比与数组的弊端就是查找缓慢，还是假设数组有100个元素，我们如果在数组里查找第五十个元素，根据首地址和下标我们就能计算出来第五十个元素的位置然后查找到，链表则需要对节点依次遍历才能找到对应节点。

## 链表的常见种类
链表是无序的，这是因为链表是通过内存指针将一组组零散的内存串联在一起。为了实现串联的功能，链表的每个节点都保存了下一个节点的地址，这个地址也就是内存指针我们可以称它为`next`。各个节点就像一条锁链，这就是它称为链表的原因。可以看出链表中最重要的就是这个内存指针`next`。链表的不同种类也是对于内存指针`next`的不同应用。下面我们列举三个最常见的链表。
### 单向链表
尾节点为`null`用来表示这是尾节点，除了尾节点以外的每个节点除了保存本身的数据还保存下一个节点的地址。

![单向链表](https:////upload.wikimedia.org/wikipedia/commons/thumb/6/6d/Singly-linked-list.svg/408px-Singly-linked-list.svg.png)

### 双向链表
首（尾）节点为`null`用来表示这是首（尾）节点，除了尾节点以外的每个节点除了保存本身的数据还保存下一个节点和上一个节点的地址。

![双向链表](https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Doubly-linked-list.svg/610px-Doubly-linked-list.svg.png)

### 循环链表
每个节点保存本身的数据和下一个节点的地址，首尾衔接。

![循环链表](https:////upload.wikimedia.org/wikipedia/commons/thumb/d/df/Circularly-linked-list.svg/350px-Circularly-linked-list.svg.png)
