# 在Linux系统Centos7中安装Docker

## 1. 如果有旧版本的Docker，先卸载旧版本的Docker
```bash
$ systemctl stop docker
$ sudo yum remove docker \
                docker-client \
                docker-client-latest \
                docker-common \
                docker-latest \
                docker-latest-logrotate \
                docker-logrotate \
                docker-engine
```

## 2. 从阿里云的yum源安装
### 2.1 安装前置依赖包
```bash
$ sudo yum install -y yum-utils \
    device-mapper-persistent-data \
    lvm2
```
### 2.2 设置软件源并更新
```bash
$ sudo yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
$ sudo yum makecache fast
```

### 2.3 查看可用的版本
按可用版本从高版本到低版本排列
```bash
$ yum list docker-ce --showduplicates | sort -r
docker-ce.x86_64            3:19.03.1-3.el7                     docker-ce-stable
docker-ce.x86_64            3:19.03.0-3.el7                     docker-ce-stable
docker-ce.x86_64            3:18.09.8-3.el7                     docker-ce-stable
docker-ce.x86_64            3:18.09.7-3.el7                     docker-ce-stable
docker-ce.x86_64            3:18.09.6-3.el7                     docker-ce-stable
docker-ce.x86_64            3:18.09.5-3.el7                     docker-ce-stable
docker-ce.x86_64            3:18.09.4-3.el7                     docker-ce-stable
docker-ce.x86_64            3:18.09.3-3.el7                     docker-ce-stable
docker-ce.x86_64            3:18.09.2-3.el7                     docker-ce-stable
docker-ce.x86_64            3:18.09.1-3.el7                     docker-ce-stable
docker-ce.x86_64            3:18.09.0-3.el7                     docker-ce-stable
docker-ce.x86_64            18.06.3.ce-3.el7                    docker-ce-stable
docker-ce.x86_64            18.06.2.ce-3.el7                    docker-ce-stable
docker-ce.x86_64            18.06.1.ce-3.el7                    docker-ce-stable
docker-ce.x86_64            18.06.0.ce-3.el7                    docker-ce-stable
docker-ce.x86_64            18.03.1.ce-1.el7.centos             docker-ce-stable
docker-ce.x86_64            18.03.0.ce-1.el7.centos             docker-ce-stable
docker-ce.x86_64            17.12.1.ce-1.el7.centos             docker-ce-stable
$ yum list docker-ce-cli --showduplicates
```

### 2.4 安装指定版本
如果不指定则默认安装最新版，这里我们安装3:19.03.1-3.el7，也就是19.03.1版本
```bash
$ sudo yum install -y docker-ce-19.03.1 docker-ce-cli-19.03.1 containerd.io
$ docker --version
Docker version 19.03.1, build 74b1e89
```

### 2.5 开启docker服务
```bash
$ systemctl start docker
# 设置开机自启动
$ systemctl enable docker
Created symlink from /etc/systemd/system/multi-user.target.wants/docker.service to /usr/lib/systemd/system/docker.service.
# 检查是否设置成功,返回enabled为成功
$ systemctl is-enabled docker
enabled
```

## 3. 卸载
### 3.1 卸载docker
```bash
$ sudo yum remove docker-ce
```
### 3.2 删除docker相关文件，默认在`/var/lib/docker`
```bash
$ sudo rm -rf /var/lib/docker
```
