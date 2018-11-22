<template>
  <el-container style="border: 1px solid #eee">
    <el-aside :style="isCollapse?'width:150px':'width:200px'" style="background-color: rgb(238, 241, 246);padding-right: 1rem;">
      <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
        <el-radio-button :label="false">展开{{active}}</el-radio-button>
        <el-radio-button :label="true">收起</el-radio-button>
      </el-radio-group>
      <el-menu :default-active="active" class="el-menu-vertical-demo" :collapse="isCollapse" :router="true">
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
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>查看</el-dropdown-item>
            <el-dropdown-item>新增</el-dropdown-item>
            <el-dropdown-item>删除</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>王小虎</span>
      </el-header>
      <el-main>
        <router-view/>
      </el-main>
    </el-container>
  </el-container>

</template>

<script src="./home.js"></script>
<style src="./home.css"></style>
