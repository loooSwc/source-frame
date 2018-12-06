<template>
  <div>
    <el-form :model="user" class="sf-form" status-icon :rules="rules" ref="user" label-width="120px" size="small">
      <el-form-item label="用户账户" prop="userAccount">
        <el-input v-model="user.userAccount" placeholder="请输入用户账户"></el-input>
      </el-form-item>
      <el-form-item label="角色" prop="roleId">
        <el-select v-model="user.roleId" placeholder="请选择角色">
          <el-option
            v-for="role in roleList"
            :key="role.roleId"
            :label="role.roleName"
            :value="role.roleId">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="登陆密码" prop="firstPassword">
        <el-input v-model="user.firstPassword" type="password" placeholder="请输入登陆密码"></el-input>
      </el-form-item>
      <el-form-item label="确认密码" prop="secondPassword">
        <el-input v-model="user.secondPassword" type="password" placeholder="请输入确认密码"></el-input>
      </el-form-item>
      <el-form-item label="用户名称">
        <el-input v-model="user.userName" placeholder="请输入用户名称" maxlength="20"></el-input>
      </el-form-item>
      <el-form-item label="手机号" prop="userPhone">
        <el-input v-model="user.userPhone" placeholder="请输入手机号" maxlength="20"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" prop="userEmail" maxlength="50">
        <el-input v-model="user.userEmail" placeholder="请输入邮箱"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="close()" size="medium">取 消</el-button>
      <el-button type="primary" @click="commit()" size="medium">确 定</el-button>
    </div>
  </div>
</template>
<script src="./add-user.js"></script>
<style src="./add-user.css"></style>
