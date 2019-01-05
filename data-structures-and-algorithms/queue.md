# 队列

队列与栈非常相似，最基本的操作只有两个，入队（enqueue），将一个数据放到队尾；出队（dequeue），从队列头部取出一个数据。不同的在于栈只能在一端操作，遵循先入后出原则；队列可以在两端操作，并且遵循先入先出的原则（First In First Out）。队列和栈一样，既可以用数组实现，也可以用链表实现。如果用数组实现就叫顺序队列，如果用链表实现就叫链式队列。

## 经典应用
### 线程池
基于链表实现线程池：可以实现无限排队的无界队列（unbounded queue），但是可以会导致过多的请求排队等待，请求处理时间过长。不适用于要求快速响应的系统。
基于数组实现线程池：属于有界队列（bounded queue），队列大小有限，所以如果线程池中排队的请求超过队列上限，请求就会被拒绝，适用于要求快速响应的系统。

## 实现
由于在用数组实现的时候会有数据迁移操作，这时候可以使用循环队列来解决此类问题。
```java
// 循环队列
public class CircularQueue {
  private String[] data;
  private int size = 0;
  private int head = 0;
  private int tail = 0;

  public CircularQueue(int capacity) {
    data = new String[capacity];
    size = capacity;
  }

  public boolean enqueue(String datum) {
    if ((tail + 1) % size == head) {
      return false;
    }

    data[tail] = datum;
    tail = (tail + 1) % n;
    return true;
  }

    public boolean dequeue(String datum) {
    if (tail == head) {
      return null;
    }

    String ret = data[head];
    head = (head + 1) % n;
    return ret;
  }
}
```
