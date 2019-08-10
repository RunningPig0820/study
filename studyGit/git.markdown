# Git命令学习
> 参考 [Git Pro深入浅出](https://blog.csdn.net/ligang2585116/article/details/51707318)<br />
> 参考 [Git 官方文档](https://git-scm.com/book/zh/v2) <br />
>
> 边学变使用git命令

## 重新提交操作
提交完了才发现漏掉了几个文件没有添加，或者提交信息写错了，可以尝试重新提交：
    
    $ git commit --amend

示例：

    $ git add .
    $ git commit -m "学习重新提脚~"
    漏掉文件或者提交信息写错
    $ git add .
    $ git commit --amend  
    
## 打标签
传送门 : [Git标签](http://blog.csdn.net/ligang2585116/article/details/46468709 )
Git可以给历史中的某一个提交打上标签，以示重要。使用这个功能来标记发布结点（v1.0 等...）。
- 创建标签 <br />

Git使用两种主要类型的标签：轻量标签（lightweight）与附注标签（annotated）。 
轻量标签：很像一个不会改变的分支，它只是一个特定提交的引用
    
    $ git tag v1.0 -lw

附注标签：是存储在 Git 数据库中的一个完整对象[推荐方式]。
    
    $ git tag -constructorA v1.0 -m 'my frist version 1.0 tag'
 
- 后期打标签（对过去的提交打标签）

    
    $ git log --pretty=oneline
    $ git tag -constructorA v0.0 -m "补充标签"  96858b81
          
- 列出标签
    
    
    $ git tag
    $ git tag -l "v1.2.*"
    # 显示相关标签信息
    $ git show v1.2.0

- 提交标签 

`git push` 命令并不会传送标签到远程仓库服务器上。在创建完标签后你必须显式地推送标签到共享服务器上。        
    
    # 推送指定标签
    $ git push origin [tagname] 
    # 推送全部标签
    $ git push origin --tags

- 拉取 


    # 从服务器上抓取本地没有的数据时，它并不会修改工作目录中的内容。 它只会获取数据然后让你自己合并。
    $ git fetch  
    # git pull 在大多数情况下它的含义是下面两个命令的合体：    
    $ git fetch + git merge
   
    
- 合并分支 (很重要)

    
    # 几个分支相同
    1.可以使用 把分支push 到线上 在master上 git pull origin 
    2.git merge 
     
    # 线上分支/预发布分布分支/测试分支 代码不同合并要特别小心
    不能直接用 git merge操作
    1.git fetch origin master:tmp
      git diff tmp
      git merge tmp
    

- 变基(git rebase) 
    
    
    ps 不要对在你的仓库外有副本的分支执行变基。
  