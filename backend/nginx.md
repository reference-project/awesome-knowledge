# Nginx

- [Nginx](#nginx)
  - [nginx目录结构](#nginx%E7%9B%AE%E5%BD%95%E7%BB%93%E6%9E%84)
  - [常用命令](#%E5%B8%B8%E7%94%A8%E5%91%BD%E4%BB%A4)
  - [常用配置](#%E5%B8%B8%E7%94%A8%E9%85%8D%E7%BD%AE)
    - [引入配置文件](#%E5%BC%95%E5%85%A5%E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6)
    - [强制使用`www`开头进行访问](#%E5%BC%BA%E5%88%B6%E4%BD%BF%E7%94%A8www%E5%BC%80%E5%A4%B4%E8%BF%9B%E8%A1%8C%E8%AE%BF%E9%97%AE)
    - [强制不使用`www`开头进行访问](#%E5%BC%BA%E5%88%B6%E4%B8%8D%E4%BD%BF%E7%94%A8www%E5%BC%80%E5%A4%B4%E8%BF%9B%E8%A1%8C%E8%AE%BF%E9%97%AE)
    - [强制使用`HTTPS`](#%E5%BC%BA%E5%88%B6%E4%BD%BF%E7%94%A8https)
    - [重新定向到指定页面](#%E9%87%8D%E6%96%B0%E5%AE%9A%E5%90%91%E5%88%B0%E6%8C%87%E5%AE%9A%E9%A1%B5%E9%9D%A2)
    - [添加错误日志和访问日志](#%E6%B7%BB%E5%8A%A0%E9%94%99%E8%AF%AF%E6%97%A5%E5%BF%97%E5%92%8C%E8%AE%BF%E9%97%AE%E6%97%A5%E5%BF%97)
    - [Gzip压缩](#gzip%E5%8E%8B%E7%BC%A9)
    - [跨域配置](#%E8%B7%A8%E5%9F%9F%E9%85%8D%E7%BD%AE)
    - [开启Basic Authentication](#%E5%BC%80%E5%90%AFbasic-authentication)
    - [开启SSL缓存](#%E5%BC%80%E5%90%AFssl%E7%BC%93%E5%AD%98)
    - [静态文件元数据缓存](#%E9%9D%99%E6%80%81%E6%96%87%E4%BB%B6%E5%85%83%E6%95%B0%E6%8D%AE%E7%BC%93%E5%AD%98)
    - [负载均衡](#%E8%B4%9F%E8%BD%BD%E5%9D%87%E8%A1%A1)
  - [`proxy_pass`结尾`/`的匹配规则](#proxypass%E7%BB%93%E5%B0%BE%E7%9A%84%E5%8C%B9%E9%85%8D%E8%A7%84%E5%88%99)
  - [location 匹配规则](#location-%E5%8C%B9%E9%85%8D%E8%A7%84%E5%88%99)
  - [负载均衡策略](#%E8%B4%9F%E8%BD%BD%E5%9D%87%E8%A1%A1%E7%AD%96%E7%95%A5)
    - [轮询策略](#%E8%BD%AE%E8%AF%A2%E7%AD%96%E7%95%A5)
    - [权重策略](#%E6%9D%83%E9%87%8D%E7%AD%96%E7%95%A5)
    - [Ip-Hash策略](#ip-hash%E7%AD%96%E7%95%A5)
    - [Fair策略（第三方提供）](#fair%E7%AD%96%E7%95%A5%E7%AC%AC%E4%B8%89%E6%96%B9%E6%8F%90%E4%BE%9B)
    - [UrlHash策略](#urlhash%E7%AD%96%E7%95%A5)
    - [负载均衡服务状态设置](#%E8%B4%9F%E8%BD%BD%E5%9D%87%E8%A1%A1%E6%9C%8D%E5%8A%A1%E7%8A%B6%E6%80%81%E8%AE%BE%E7%BD%AE)
  - [使用nginxconfig.io进行配置生成](#%E4%BD%BF%E7%94%A8nginxconfigio%E8%BF%9B%E8%A1%8C%E9%85%8D%E7%BD%AE%E7%94%9F%E6%88%90)

## nginx目录结构
```
.                       # /etc/nginx
├── conf.d
├── fastcgi.conf        # fastcgi配置
├── fastcgi_params      # fastcgi相关参数文件
├── koi-utf             # 编码转换映射文件，koi8-r < -- > utf-8
├── koi-win             # 编码转换映射文件，koi8-r < -- > windows-1251
├── mime.types          # 媒体类型
├── nginx.conf          # Nginx主配置文件
├── proxy_params
├── scgi_params         # scgi相关参数文件
├── sites-available     # 可用站点配置 ( 含废弃，历史，存档等配置 )
├── sites-enabled       # 目前启用的站点配置
├── snippets            # 配置片段
├── uwsgi_parasm        # uwsgi相关参数文件
└── win-utf             # 编码转换映射文件，windows-1251 < -- > utf-8
```

## 常用命令
```
Usage: nginx [-?hvVtTq] [-s signal] [-c filename] [-p prefix] [-g directives]

Options:
  -?,-h         : this help
  -v            : show version and exit
  -V            : show version and configure options then exit
  -t            : test configuration and exit
  -T            : test configuration, dump it and exit
  -q            : suppress non-error messages during configuration testing
  -s signal     : send signal to a master process: stop, quit, reopen, reload
  -p prefix     : set prefix path (default: /usr/share/nginx/)
  -c filename   : set configuration file (default: /etc/nginx/nginx.conf)
  -g directives : set global directives out of configuration file

# 检查 nginx 当前版本
nginx -V

# 检查 nginx 配置是否正确
nginx -t

# 停止服务
nginx -s stop

# 退出服务
nginx -s quit

# 重启服务
nginx -s reload

# 设置配置文件
nginx -c
```

## 常用配置
### 引入配置文件
1. 在`nginx.conf`文件中`http`模块添加以下代码
```
# 一般来说下面这行代码会存在，且是被注释状态，将注释取消就好
include /etc/nginx/sites-enabled/*;
```
2. 从 `site-available` 复制模板文件`default`到 `site-enabled` 目录下，并且自行重命名
```
cd /etc/nginx/
cp ./sites-available/default ./sites-enabled/
```
3. 重新加载配置文件
```
nginx -s reload
```
### 强制使用`www`开头进行访问
```nginx
server {
    listen 80;
    server_name example.com;
    return 301 $scheme://www.example.org$request_uri;
}

server {
    listen 80;
    server_name www.example.com;
}
```
### 强制不使用`www`开头进行访问
```nginx
server {
    listen 80;
    server_name example.org;
}

server {
    listen 80;
    server_name www.example.org;
    return 301 $scheme://example.org$request_uri;
}
```
### 强制使用`HTTPS`
```nginx
server {
    listen 80;
    return 301 https://$host$request_uri;
}

server {
    listen 443 ssl;

    # let the browsers know that we only accept HTTPS
    add_header Strict-Transport-Security max-age=2592000;

# don’t use SSLv3 ref: POODLE CVE-2014-356 - http://nginx.com/blog/nginx-poodle-ssl/
    ssl_protocols  TLSv1 TLSv1.1 TLSv1.2;  

# Ciphers set to best allow protection from Beast, while providing forwarding secrecy, as defined by Mozilla (Intermediate Set) - https://wiki.mozilla.org/Security/Server_Side_TLS#Nginx
    ssl_ciphers 'ECDHE-RSA-AES128-GCM-SHA256:ECDHE-ECDSA-AES128-GCM-SHA256:ECDHE-RSA-AES256-GCM-SHA384:ECDHE-ECDSA-AES256-GCM-SHA384:DHE-RSA-AES128-GCM-SHA256:DHE-DSS-AES128-GCM-SHA256:ECDHE-RSA-AES128-SHA256:ECDHE-ECDSA-AES128-SHA256:ECDHE-RSA-AES128-SHA:ECDHE-ECDSA-AES128-SHA:ECDHE-RSA-AES256-SHA384:ECDHE-ECDSA-AES256-SHA384:ECDHE-RSA-AES256-SHA:ECDHE-ECDSA-AES256-SHA:DHE-RSA-AES128-SHA256:DHE-RSA-AES128-SHA:DHE-DSS-AES128-SHA256:DHE-RSA-AES256-SHA256:DHE-DSS-AES256-SHA:DHE-RSA-AES256-SHA:AES128-GCM-SHA256:AES256-GCM-SHA384:AES128-SHA256:AES256-SHA256:AES128-SHA:AES256-SHA:AES:CAMELLIA:DES-CBC3-SHA:!aNULL:!eNULL:!EXPORT:!DES:!RC4:!MD5:!PSK:!aECDH:!EDH-DSS-DES-CBC3-SHA:!EDH-RSA-DES-CBC3-SHA:!KRB5-DES-CBC3-SHA';
    ssl_prefer_server_ciphers  on;
}
```
### 重新定向到指定页面
```nginx
server {
    location = /oldpage.html {
        return 301 http://example.org/newpage.html;
    }
}
```
### 添加错误日志和访问日志
在`http`模块和`server`模块中添加都可以
```nginx
error_log /var/log/nginx/example-error.log;
access_log /var/log/nginx/example-access.log
```
### Gzip压缩
gzip  on;
gzip_buffers 16 8k;
gzip_comp_level 6;
gzip_http_version 1.1;
gzip_min_length 256;
gzip_proxied any;
gzip_vary on;
gzip_types
    text/xml application/xml application/atom+xml application/rss+xml application/xhtml+xml image/svg+xml
    text/javascript application/javascript application/x-javascript
    text/x-json application/json application/x-web-app-manifest+json
    text/css text/plain text/x-component
    font/opentype application/x-font-ttf application/vnd.ms-fontobject
    image/x-icon;
gzip_disable  "msie6";

### 跨域配置
```nginx
location ~* \.(eot|ttf|woff) {
    add_header Access-Control-Allow-Origin *;
}
```
### 开启Basic Authentication
```nginx
server {
    location {
        auth_basic "This is Protected";
        auth_basic_user_file /etc/nginx/conf.d/account;
    }
}
```
```
# /etc/nginx/conf.d/account
# 账号：root，密码：123456
root:123456
```

### 开启SSL缓存
```nginx
ssl_session_cache shared:SSL:10m;
ssl_session_timeout 10m;
```
### 静态文件元数据缓存
```nginx
open_file_cache max=1000 inactive=20s;
open_file_cache_valid 30s;
open_file_cache_min_uses 2;
open_file_cache_errors on;
```
### 负载均衡
```nginx
upstream backend {
    server 127.0.0.1:8080;
    server 127.0.0.1:8081;
    keepalive 32;
}

server {
    location /api/ {
        proxy_pass http://backend;
        proxy_http_version 1.1;
        proxy_set_header Connection "";
    }
}
```

## `proxy_pass`结尾`/`的匹配规则
```nginx
# input http://example/proxy/test

# proxy http://127.0.0.1:3000/test
location /proxy/ {
    proxy_pass http://127.0.0.1:3000/;
}

# proxy http://127.0.0.1:3000/proxy/test
location /proxy/ {
    proxy_pass http://127.0.0.1:3000;
}

# proxy http://127.0.0.1:3000/suffix/test
location /proxy/ {
    proxy_pass http://127.0.0.1:3000/suffix/;
}

# proxy http://127.0.0.1:3000/suffixtest
location /proxy/ {
    proxy_pass http://127.0.0.1:3000/suffix;
}
```

## location 匹配规则
- `=`开头表示精确匹配
- `^~`开头表示uri以字符串开头，非正则匹配
- `~`开头表示区分大小写的正则匹配
- `~*` 开头表示不区分大小写的正则匹配
- `/`通用匹配

> 优先级：(location =) > (location 完整路径) > (location ^~ 路径) > (location ~,~* 正则顺序) > (location 部分起始路径) > (/)

## 负载均衡策略
### 轮询策略
```nginx
upstream strategy { 
    server 127.0.0.1:8080;
    server 127.0.0.1:8081;
} 
```
### 权重策略
```nginx
upstream strategy { 
    server 127.0.0.1:8080 weight=1;
    server 127.0.0.1:8081 weight=2;
} 
```
### Ip-Hash策略
```nginx
# 按访问服务Ip的hash结果来分配请求，使每个url定向到同一个后端服务器
upstream strategy { 
    ip_hash; 
    server 127.0.0.1:8080;
    server 127.0.0.1:8081;
} 
```
### Fair策略（第三方提供）
```nginx
# 按后端服务器的响应时间来分配请求，响应时间短的优先分配。 
upstream strategy { 
    fair;
    server 127.0.0.1:8080;
    server 127.0.0.1:8081;
} 
```
### UrlHash策略
```nginx
# 按访问url的hash结果来分配请求，使每个url定向到同一个后端服务器，
upstream strategy { 
    fair;
    server 127.0.0.1:8080;
    server 127.0.0.1:8081;
    hash $request_uri; 
    hash_method crc32; 
} 
```
### 负载均衡服务状态设置
- `down`：表示当前服务不参与负载均衡。
- `weight`：权重，越高被访问的几率越大。
- `max_fails`：允许请求失败的次数默认为1.当超过最大次数时，返回proxy_next_upstream 模块定义的错误。
- `fail_timeout`：失败次数达到`max_fails`指定的次数后，服务暂停的时间。 
- `backup`：其它所有的非`backup`机器`down`或者繁忙的时候，会请求backup机器，可以用来实现双机热备。

## 使用[nginxconfig.io](https://nginxconfig.io/)进行配置生成
