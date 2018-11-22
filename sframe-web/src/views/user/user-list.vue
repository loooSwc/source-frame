<template>
  <el-table :data="tableData" stripe style="width: 100%">
    <el-table-column prop="date" label="日期">
    </el-table-column>
    <el-table-column  prop="name"
      label="姓名"
      >
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址">
    </el-table-column>
  </el-table>
  <el-pagination
    @size-change="handleSizeChange"
    @current-change="handleCurrentChange"
    :current-page.sync="currentPage1"
    :page-size="100"
    layout="total, prev, pager, next"
    :total="1000">
  </el-pagination>
</template>

<script src="./user-list.js"></script>
<style src="./user-list.css"></style>
