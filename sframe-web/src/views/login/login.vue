<template>
  <div class="login">
    <el-form  label-width="0px"
             class="demo-ruleForm middle-box text-center loginscreen login-form">
      <h4>用户登陆</h4>
      <el-form-item>
        <el-input placeholder="请输入用户名" v-model="userAccount">
          <template slot="prepend"><img src="../../assets/img/user.png" class="icon-img"></template>
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-input placeholder="请输入密码" type="password" v-model="userPassword">
          <template slot="prepend"><img src="../../assets/img/password.png" class="icon-img"></template>
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="text" class="forget-password">忘记密码?</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" class="login-button" size="medium" @click="login()">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script src="./login.js"></script>
<style src="./login.css"></style>
