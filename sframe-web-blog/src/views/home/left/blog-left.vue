<template>
  <section style="width: 246px;">
    <el-card shadow="never" style="text-align: center;background: black;" :key="1">
      <div  style="font-size: 1.3rem;line-height: 3.5;">
        <span style="color: white;">Java Coder</span>
      </div>
    </el-card>
          <el-card shadow="never" :key="2" style="margin-bottom: 20px;">
            <el-menu :default-active="active">
              <el-menu-item index="/">
                <span slot="title">首页</span>
              </el-menu-item>
              <el-menu-item index="/">
                <span slot="title">标签</span>
              </el-menu-item>
              <el-menu-item index="/">
                <span slot="title">分类</span>
              </el-menu-item>
              <el-menu-item index="/">
                <span slot="title">归档</span>
              </el-menu-item>
            </el-menu>
          </el-card>
    <div  :class="postion">
      <el-card shadow="never" style="text-align: center" :key="3" >
        <img src="https://avatars1.githubusercontent.com/u/22002598?s=100&v=4" class="image">
        <div  style="font-size: 0.9rem;line-height: 1.5;color: #606c71;">
          <span style="font-weight: bold;">c.9u</span>
        </div>
        <div class="site-state motion-element">
          <div class="site-state-item site-state-posts">

            <a href="/archives/">

              <span class="site-state-item-count">6</span>
              <span class="site-state-item-name">日志</span>
            </a>
          </div>
          <div class="site-state-item site-state-posts">

            <a href="/archives/">

              <span class="site-state-item-count">6</span>
              <span class="site-state-item-name">日志</span>
            </a>
          </div>
          <div class="links-of-author motion-element">
              <span class="links-of-author-item">
                <a href="https://github.com/loooSwc" target="_blank" title="GitHub">
                    <i class="fa fa-fw fa-github"></i>
                      GitHub

                </a>
              </span>
            <span class="links-of-author-item">
                <a href="mailto:c.9u@outlook.com" target="_blank" title="E-Mail">
                    <i class="fa fa-fw fa-envelope"></i>
                      E-Mail
                </a>
              </span>
          </div>
        </div>
      </el-card>
      <el-card shadow="never" style="text-align: center" :key="4">
        <div  style="font-size: 0.9rem;line-height: 1.5;color: #606c71;">
          <i class="fa  fa-fw fa-globe"></i>
          <span style="font-weight: bold;">Links</span>
        </div>
        <ul class="links-of-blogroll-list">
          <li class="links-of-blogroll-item">
            <a href="http://loooswc.cn" title="LoooSwc" target="_blank">LoooSwc</a>
          </li>
          <li class="links-of-blogroll-item">
            <a href="http://www.lonelymoon.cn/" title="LonelyMoon" target="_blank">LonelyMoon</a>
          </li>

        </ul>
      </el-card>
    </div>
  </section>
</template>

<script src="./blog-left.js"></script>
<style src="./blog-left.css"></style>
