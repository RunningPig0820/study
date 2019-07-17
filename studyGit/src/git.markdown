# Git命令学习
> 参考 [Git Pro深入浅出](https://blog.csdn.net/ligang2585116/article/details/51707318)

## 重新提交操作
提交完了才发现漏掉了几个文件没有添加，或者提交信息写错了，可以尝试重新提交：
    
    $ git commit --amend

示例：

    $ git add .
    $ git commit -m "学习重新提脚~"
    漏掉文件或者提交信息写错
    $ git add .
    $ git commit --amend      