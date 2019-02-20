<template>
  <div>
    <section class="main-content">
      <el-row>
        <transition-group name="el-zoom-in-center">
        <el-col  style="width: 246px;" key="1">
          <blog-left></blog-left>
        </el-col>
        <el-col :span="18" style="padding-left:10px;margin-left: 250px;position: absolute;" key="2">
          <router-view/>
        </el-col>
        </transition-group>
      </el-row>

    </section>

    <div style="text-align: center">

    </div>

  </div>

</template>

<script src="./home.js"></script>
<style src="./home.css"></style>
