<template>
  <el-container style="border: 1px solid #eee">
    <el-aside  style="background-color: rgb(238, 241, 246);padding-right: 1rem;width: auto;">
      <span class= "menu-hide" :class="isCollapse ? 'el-icon-d-arrow-right' : 'el-icon-d-arrow-left' " v-model="isCollapse" @click="isCollapse = !isCollapse"></span>
      <el-menu :default-active="active" class="el-menu-vertical" :collapse="isCollapse" :router="true">
        <el-submenu :index="index+''" v-for="(item,index) in menuList" v-if="item.childMenus && item.childMenus.length > 0">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span slot="title">{{item.menuName}}</span>
          </template>
          <el-menu-item-group  v-for="(child,childIndex) in item.childMenus">
            <el-menu-item :index="child.menuRouter">{{child.menuName}}</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-menu-item :index="item.menuRouter"v-else v-on:click="changeActive(item.menuRouter)">
          <i class="el-icon-menu"></i>
          <span slot="title">{{item.menuName}}</span>
        </el-menu-item>
      </el-menu>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <el-dropdown @command="handleCommand">
          <span>{{userAccount}}</span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="">退出</el-dropdown-item>
            <el-dropdown-item>新增</el-dropdown-item>
            <el-dropdown-item>删除</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-header>
      <el-main class="sf-main">
        <router-view/>
      </el-main>
    </el-container>
  </el-container>

</template>

<script src="./home.js"></script>
<style src="./home.css"></style>
