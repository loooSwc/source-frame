<template>
  <div>
    <el-table :data="tableData.result" stripe style="width: 100%">
      <el-table-column prop="userAccount" label="账户" show-overflow-tooltip></el-table-column>
      <el-table-column prop="userName" label="姓名" show-overflow-tooltip></el-table-column>
      <el-table-column prop="roleName" label="角色" show-overflow-tooltip></el-table-column>
      <el-table-column prop="userEmail" label="邮箱" show-overflow-tooltip></el-table-column>
      <el-table-column prop="userPhone" label="手机" show-overflow-tooltip></el-table-column>
      <el-table-column prop="createTime " :formatter="dataFormat" label="创建日期" show-overflow-tooltip></el-table-column>
      <el-table-column prop="lastLoginTime" :formatter="dataFormat" label="最后登录日期"
                       show-overflow-tooltip></el-table-column>
      <el-table-column label="状态" show-overflow-tooltip>
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.isEnable"
            active-value="0"
            inactive-value="1">
          </el-switch>
          <span>{{scope.row.isEnable=='0'?'启用':'禁用'}}</span>
        </template>
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="130">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="edit(scope.row)">编辑</el-button>
          <el-dropdown trigger="click">
            <el-button type="text" size="small">更多操作<i class="el-icon-arrow-down el-icon--right"></i></el-button>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>
                <el-button @click="handleClick(scope.row)" type="text" size="small">禁用</el-button>
              </el-dropdown-item>
              <el-dropdown-item>
                <el-button @click="handleClick(scope.row)" type="text" size="small" class="button-color-red">删除
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

<script src="./user-list.js"></script>
<style src="./user-list.css"></style>
