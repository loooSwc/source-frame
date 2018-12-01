<template>
  <div>
      <el-form :model="user" class="sf-form">
        <el-form-item label="用户账户" label-width="120px">
            {{user.userAccount}}
        </el-form-item>
        <el-form-item label="角色" label-width="120px">
          {{user.roleName}}
        </el-form-item>
        <el-form-item label="用户名称" label-width="120px">
          <el-input v-model="user.userName" placeholder="请输入用户名称" size="small"></el-input>
        </el-form-item>
        <el-form-item label="手机号" label-width="120px">
          <el-input v-model="user.userPhone" placeholder="请输入手机号" size="small"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" label-width="120px">
          <el-input v-model="user.userEmail" placeholder="请输入邮箱" size="small"></el-input>
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
