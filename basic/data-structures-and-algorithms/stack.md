# 栈

栈这种数据结构只允许在链表或者数组的一端进行加入数据和删除数据，按照后进先出（LIFO, Last In First Out）的原理运作。

## 经典应用
### 浏览器的前进后退
浏览器的前进后退功能就是依靠的栈数据结构进行的实现。
我们使用两个栈X和Y，X负责存储前进页面，Y负责存储后退页面，我们把首次浏览的页面依次压入X栈，当点击后退按钮的时候，再依次从X栈中将页面取出，并将页面放入Y栈，前进时的操作原理反之，这样当X栈中没有数据，说明没有页面可以继续后退浏览了，当Y栈中没有数据就说明没有页面可以继续前进浏览了。

## 栈的实现
栈主要包含两个操作，出栈和入栈，在实现方面既可以用链表也可以用数组进行实现，用数组实现的栈叫做顺序栈，用链表实现的栈叫链式栈。
```java
// 基于数组实现的顺序栈
public class ArrayStack {
    private String[] data;
    private int size;
    private int n;

    public ArrayStack(int n) {
        this.data = new String[n];
        this.n = n;
        this.size = 0;
    }

    public boolean push(String datum) {
        if (size == n) {
            return false;
        }
        data[size] = datum;
        ++size;
        return true;
    }

    public String pop() {
        if (size == 0) {
            return null;
        }

        String tmp = data[size - 1];
        --size;
        return tmp;
    }
}
```
