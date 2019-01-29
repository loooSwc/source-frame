<template>
  <div>
    <el-form :model="user" class="sf-form" status-icon :rules="rules" ref="user" label-width="120px" size="small">
      <el-form-item label="登陆密码" prop="firstPassword">
        <el-input v-model="user.firstPassword" type="password" placeholder="请输入登陆密码"></el-input>
      </el-form-item>
      <el-form-item label="确认密码" prop="secondPassword">
        <el-input v-model="user.secondPassword" type="password" placeholder="请输入确认密码"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="close()" size="medium">取 消</el-button>
      <el-button type="primary" @click="commit()" size="medium">确 定</el-button>
    </div>
  </div>
</template>

<script src="./edit-password.js"></script>

<style src="./edit-password.css"></style>
