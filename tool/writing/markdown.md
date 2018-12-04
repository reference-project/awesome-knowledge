# Markdown

## 标题
```markdown
# h1
## h2
### h3
#### h4
##### h5
###### h6
```
```markdown
// 等于`# h1`
h1
========
```
```markdown
// 等于`## h2`
h2
--------
```

## 列表
```markdown
// 无序列表
* item 1
* item 2
```
```markdown
// 无序列表
- item 1
- item 2
```
```markdown
// 有序列表
1. item 1
2. item 2
```
```markdown
// 无序列表嵌套
* item 1
    * item 1-1
        * item 1-1-1
* item 2
```
```markdown
// 有序列表嵌套
1. item 1
    1. item 1-1
    2. item 1-2
2. item 2
```
```markdown
// 混合列表嵌套
1. item 1
    - item 1-1
    - item 1-2
2. item 2
```

## 倾斜文本
```markdown
*字体倾斜*
```
```markdown
_字体倾斜_
```

## 加粗文本
```markdown
**字体倾斜**
```
```markdown
__字体倾斜__
```

## 删除线文本
```markdown
~~字体倾斜~~
```

## 加粗并倾斜文本
```markdown
___加粗并倾斜文本___
```
```markdown
***加粗并倾斜文本***
```

## 链接
```markdown
// 有名称链接
[Named Link](https://www.google.com/)
```
```markdown
// 直接显示链接地址
https://www.google.com/
```
```markdown
// 直接显示链接地址
<https://www.google.com/>
```

## 代码
```markdown
// 行内代码
`code`
```
```markdown
// 使用的时候把转义符\去掉
\`\`\`
代码块
\`\`\`
```
```markdown
    四个空格同样被标记为代码块
```
```markdown
// 具有颜色高亮的代码引用，使用的时候把转义符\去掉
\`\`\`java
String str = new String();
\`\`\`
```

## 分割线
```markdown
----
```
```markdown
****
```

## 图片
```markdown
![Google Logo](https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png)
```
```markdown
![Google Logo](https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png "Google Logo")
```
```markdown
// 引用下面定义的变量 logo 来展示图片
![Google Logo][logo]

// 定义变量 logo
[logo]: https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png
```

## 引用
```markdown
> 这是引用
> 这是引用
```
```markdown
> > 这是嵌套引用
> > 这是嵌套引用
```

## 表格
```markdown
| 第一行第一列 | 第一行第二列 |
| ---------- | ---------- |
| 第二行第一列 | 第二行第二列 |
```
```markdown
| 第一行第一列 | 第一行第二列 |
--- | ---
| 第二行第一列 | 第二行第二列 |
```

## 折叠
```markdown
<details>
    <summary>Title 1</summary>
    <p>Content 1 Content 1 Content 1 Content 1 Content 1</p>
</details>
```
