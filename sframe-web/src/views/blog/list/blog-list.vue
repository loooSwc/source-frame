<template>
  <div>
    <el-form :inline="true" :model="queryParams" class="demo-form-inline" @submit.native.prevent>
      <el-form-item>
        <el-input type="text" v-model="queryParams.userEmail" placeholder="请输入邮箱搜索" prefix-icon="el-icon-search" @keyup.enter.native="getUserPage()"></el-input>
      </el-form-item>
      <el-form-item style="float: right;">
        <el-button type="primary"  icon="el-icon-plus" @click="addBlog()">新增文章</el-button>
      </el-form-item>
    </el-form>
    <el-table :data="tableData.result" stripe style="width: 100%">
      <el-table-column prop="userAccount" label="账户" show-overflow-tooltip></el-table-column>
      <el-table-column prop="userName" label="姓名" show-overflow-tooltip></el-table-column>
      <el-table-column prop="roleName" label="角色" show-overflow-tooltip></el-table-column>
      <el-table-column prop="userEmail" label="邮箱" show-overflow-tooltip></el-table-column>
      <el-table-column prop="userPhone" label="手机" show-overflow-tooltip></el-table-column>
      <el-table-column prop="createTime" :formatter="dataFormat" label="创建日期" show-overflow-tooltip></el-table-column>
      <el-table-column prop="lastLoginTime" :formatter="dataFormat" label="最后登录日期"
                       show-overflow-tooltip></el-table-column>
      <el-table-column label="状态" show-overflow-tooltip>
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.isEnable"
            active-value="1"
            inactive-value="0"
            @change="changeStatus($event,scope.row)">
          </el-switch>
          <span>{{scope.row.isEnable=='1'?'启用':'禁用'}}</span>
        </template>
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="130">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="editUser(scope.row)">编辑</el-button>
          <el-dropdown trigger="click">
            <el-button type="text" size="small">更多操作<i class="el-icon-arrow-down el-icon--right"></i></el-button>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>
                <el-button @click="editPassword(scope.row)" type="text" size="small">修改密码</el-button>
              </el-dropdown-item>
              <el-dropdown-item>
                <el-button @click="resetPassword(scope.row)" type="text" size="small">重置密码</el-button>
              </el-dropdown-item>
              <el-dropdown-item>
                <el-button @click="deleteUser(scope.row)" type="text" size="small" class="button-color-red">删除
                </el-button>
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="getUserPage"
      @current-change="getUserPage"
      :current-page.sync="tableData.currentPageNo"
      :page-size="tableData.pageSize"
      layout="total, prev, pager, next, jumper"
      :total="tableData.totalCount">
    </el-pagination>
  </div>

</template>

<script src="./blog-list.js"></script>
<style src="./blog-list.css"></style>
