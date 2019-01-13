# 每个开发者应该了解的Linux命令

> [Linux命令大全](http://man.linuxde.net/)，有不会的就直接搜

## 常用命令
```bash
pidof nginx                                       # 输出 nginx 的进程 ID
pkill -f nginx                                    # 按照进程名称终止所有的进程
tree                                              # 以树状结构列出目录内容
htop                                              # 拥有漂亮、多彩的命令行界面
pwd                                               # 在终端中显示当前工作目录的全路径。
cd                                                # 要变更你当前所在的目录。
kill                                              # 快速关闭一个进程。
history                                           # 查询历史记录命令。
sudo                                              # 命令允许授权用户执行超级用户或者其它用户的命令。
chmod                                             # 修改文件的访问权限。
chown                                             # 改变文件拥有者和所在用户组。
ps -ef | grep nginx                               # 显示所有进程状态 -ef 查看进程信息
netstat -tp                                       # 查看网络连接命令
tail -100f example.log                            # 在线查看日志
curl                                              # 上传下载http请求无所不能
whereis nginx                                     # 查找应用位置
su -username                                      # 切换用户
reboot                                            # 重启命令
shutdown -r now                                   # 立刻重启
shutdown -r 10                                    # 过10分钟自动重启
shutdown -c                                       # 取消重启
halt                                              # 关机命令
``` 

## 文件操作
```bash
stat <filename>                                   # 查看文件统计信息 
file <filename>                                   # 查看文件类型 
cat <filename>                                    # 查看文件内容，文本加行号 
find / -name filename.txt                         # 根据名称查找/目录下的filename.txt文件。
find . -name "*.xml"                              # 递归查找所有的xml文件
find . -name "*.xml" |xargs grep "hello world"    # 递归查找所有文件内容中包含hello world的xml文件
grep -H 'spring' *.xml                            # 查找所有的包含spring的xml文件
find ./ -size 0 | xargs rm -f &                   # 删除文件大小为零的文件
ls -l | grep '.jar'                               # 查找当前目录中的所有jar文件
grep 'test' d*                                    # 显示所有以d开头的文件中包含test的行。
grep 'test' aa bb cc                              # 显示在aa，bb，cc文件中匹配test的行。
grep '[a-z]\{5\}' aa                              # 显示所有包含每个字符串至少有5个连续小写字符的字符串的行。
ls                                                # 列出目录内容
mkdir                                             # 创建一个新的目录。
cp                                                # 复制文件/重命名文件。
mv                                                # 移动文件。
touch                                             # 创建一个新文件，或者将文件的访问和修改时间更新为当前时间。
tar -xvzf test.tar.gz                             # 解压文件
```

## 主机信息
```bash
uname -a                                          # 查看操作系统相关信息
cat /proc/version                                 # 查看内核版本
cat /etc/issue                                    # 查看发行版本信息
df -h                                             # 查看磁盘使用和挂载信息
ifconfig                                          # 查看网络配置信息
```

## 查找端口
```bash
netstat -tln                                      # 端口使用情况
netstat -tln | grep 8080                          # 特定端口使用情况
lsof -i :8080                                     # 端口属于哪个程序
```

## apt-get
```bash
apt-get update                                    # 检查更新
apt-get upgrade                                   # 系统升级
apt-get remove xxx                                # 移除软件
apt-get autoremove                                # 自动删除所有未使用的包
apt-get purge xxx                                 # 完全移除软件包（包括配置文件等）
apt-get clean                                     # 删除下载的软件包
```
