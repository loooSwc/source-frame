<template>
  <div>
      <el-form :model="user" class="sf-form" status-icon :rules="rules" ref="user" label-width="120px" size="small">
        <el-form-item label="用户账户">
            {{user.userAccount}}
        </el-form-item>
        <el-form-item label="角色">
          {{user.roleName}}
        </el-form-item>
        <el-form-item label="用户名称"  maxlength="20">
          <el-input v-model="user.userName" placeholder="请输入用户名称"></el-input>
        </el-form-item>
        <el-form-item label="手机号" prop="userPhone"  maxlength="20">
          <el-input v-model="user.userPhone" placeholder="请输入手机号"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="userEmail"  maxlength="50">
          <el-input v-model="user.userEmail" placeholder="请输入邮箱"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="close()" size="medium">取 消</el-button>
        <el-button type="primary" @click="commit()" size="medium">确 定</el-button>
      </div>
  </div>
</template>
<script src="./edit-user.js"></script>
<style src="./edit-user.css"></style>
