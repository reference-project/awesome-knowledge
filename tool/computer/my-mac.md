# 我的Mac配置与日常工具

[我的Mac配置与日常工具](#我的mac配置与日常工具)
- [终端系列](#终端系列)
- [翻墙系列](#翻墙系列)
- [编辑器](#编辑器)
- [浏览器](#浏览器)
- [日常开发](#日常开发)
- [设计作图](#设计作图)
- [日常使用](#日常使用)

## 终端系列
- [Iterm2](https://github.com/gnachman/iTerm2)：Mac OS X的终端模拟工具
- [OhMyZsh](https://github.com/robbyrussell/oh-my-zsh)：zsh社区驱动框架，用来美化和管理你的zsh配置
- [Homebrew](https://brew.sh/index_zh-cn.html)：Mac OS 软件包的管理器

## 翻墙系列
- [ShadowsocksX](https://github.com/shadowsocks/shadowsocks/wiki): 翻墙工具，三端都可用。
- [美国AppleId账号](http://www.apid.info/)：iOS 必须要有Shadowrocket软件才可以进行翻墙，而这个软件必须要在美版 AppleStore 才能下载。
- [搬瓦工](https://bandwagonhost.com/)：需翻墙才能进入。可以在里面购买便宜的服务器用来搭建shadowsock服务。购买之前记得在百度搜索优惠码。如果不想自建可以使用[美国AppleId账号](http://www.apid.info/)中的shadowsock租用方案。

## 编辑器
- [Visual Studio Code](https://code.visualstudio.com/)
  - [One Dark Pro](https://marketplace.visualstudio.com/items?itemName=zhuangtongfa.Material-theme)：一个从 Atom 移植的主题，非常简洁好看
  - [debugger-for-chrome](https://marketplace.visualstudio.com/items?itemName=msjsdiag.debugger-for-chrome)：一个能够直接对 Chrome 中的代码进行 DEBUG 的工具
  - [Document This](https://marketplace.visualstudio.com/items?itemName=joelday.docthis)：为 JS 生成符合 JSDoc 规范的注释工具
  - [GitLens](https://marketplace.visualstudio.com/items?itemName=eamodio.gitlens)：VSC 中最好用的Git 工具
  - [Markdown TOC](https://marketplace.visualstudio.com/items?itemName=AlanWalk.markdown-toc): 用来在写 Markdown 的时候生成 TOC 的工具，不一定需要
  - [Path Intellisense](https://marketplace.visualstudio.com/items?itemName=christian-kohler.path-intellisense)：路径自动补全，引入静态资源的时候必备
  - [Python](https://marketplace.visualstudio.com/items?itemName=ms-python.python)：Python 必备
  - [VS Live Share](https://marketplace.visualstudio.com/items?itemName=MS-vsliveshare.vsliveshare)：在线代码协作分享工具
  - [vscode-icons](https://marketplace.visualstudio.com/items?itemName=robertohuertasm.vscode-icons)：好看的文件夹图标
  - 
```json
// 将设置放入此文件中以覆盖默认设置
{
  "editor.fontSize": 16,
  "editor.fontFamily": "RobotoMono-Regular",
  "editor.tabSize": 2,
  "workbench.colorTheme": "One Dark Pro",
  "workbench.iconTheme": "vscode-icons",
  "gitlens.historyExplorer.enabled": true,
  "path-intellisense.mappings": {
    "@": "${workspaceRoot}/src",
  }
}
```
- [Intellij IDEA](https://www.jetbrains.com/idea/)
  - [Lombok Plugin](https://github.com/mplushnikov/lombok-intellij-plugin)：Lombok插件
  - [GrepConsole](https://github.com/krasa/GrepConsole)：给日志上色，更好辨认
  - [Alibaba Java Coding Guidelines](https://github.com/alibaba/p3c)：阿里巴巴代码规约检查工具
  - [ledis](https://www.codesmagic.com/)：Redis 的客户端插件
  - [Mybatis plugin](https://www.codesmagic.com/)：Mybatis 的插件，需要付费

## 浏览器
- [Chrome](https://www.google.com/chrome/)
  - [掘金](https://chrome.google.com/webstore/detail/%E6%8E%98%E9%87%91/lecdifefmmfjnjjinhaennhdlmcaeeeb?utm_source=chrome-ntp-icon)： 为 IT 从业者提供优质内容
  - [OneTab](https://www.one-tab.com/)：标签页管理工具，节省高达95％的内存，并减轻标签页混乱现象
  - [FireShot](https://chrome.google.com/webstore/detail/take-webpage-screenshots/mcbpblocgmgfnpjjppndjkmgjaogfceg?utm_source=chrome-ntp-icon)：网页截图工具
  - [Insight.io for Github]()：Github 代码阅读工具
  - [达达划词翻译](https://chrome.google.com/webstore/detail/%E8%BE%BE%E8%BE%BE%E5%88%92%E8%AF%8D%E7%BF%BB%E8%AF%91/cajhcjfcodjoalmhjekljnfkgjlkeajl?utm_source=chrome-ntp-icon)
  - [广告终结者](https://chrome.google.com/webstore/detail/%E5%B9%BF%E5%91%8A%E7%BB%88%E7%BB%93%E8%80%85/fpdnjdlbdmifoocedhkighhlbchbiikl?utm_source=chrome-ntp-icon)
  - [React Developer Tools](https://chrome.google.com/webstore/detail/react-developer-tools/fmkadmapgofadopljbjfkapdkoienihi?utm_source=chrome-ntp-icon)
  - [Redux DevTools](https://chrome.google.com/webstore/detail/redux-devtools/lmhkpmbekcpmknklioeibfkpmmfibljd?utm_source=chrome-ntp-icon)

## 日常开发
- [Docker](https://www.docker.com/)
- [Navicat Premium](https://www.navicat.com/en/products/navicat-premium)：数据库管理工具

## 设计作图
- [Sketch](https://www.sketchapp.com/)：设计作图工具
  - [Antd Kitchen](http://kitchen.alipay.com/): Antd自带的 Sketch 工具集
- [Balsamiq Mockups 3](https://balsamiq.com/download/)：原型和线框图工具

## 日常使用
- [有道笔记](http://note.youdao.com/)
- [有道词典](http://dict.youdao.com/)
- [网易邮件大师](https://mail.163.com/dashi/)
- [网易云音乐](https://music.163.com/)
- [PDF Expert](https://www.pdfexpert.cn/)
- [微信](https://weixin.qq.com/)
- [百度网盘](https://pan.baidu.com/)
- [Alfred3](https://www.alfredapp.com/)：Mac最好的工作流工具
- [IINA](https://github.com/lhc70000/iina)：Mac中比较好用的现代播放器
- [Postman](https://www.getpostman.com/)：接口工具
- [Clear My Mac](https://macpaw.com/):Mac清理工具
- [iStat Menus](https://bjango.com/mac/istatmenus/)：电脑运行状态监控工具
