<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right" class="breadcrumb-class">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item :to="{ path: '/home/business/blog/list' }">博客管理</el-breadcrumb-item>
      <el-breadcrumb-item>添加博客</el-breadcrumb-item>
    </el-breadcrumb>
    <el-form :model="blog" class="sf-form" status-icon :rules="rules" ref="blog" label-width="120px" size="small">
      <el-form-item label="博客标题" prop="title">
        <el-input v-model="blog.title" placeholder="博客标题"></el-input>
      </el-form-item>
      <el-form-item label="博客标签" prop="title">
        <el-input v-model="blog.tags" placeholder="博客标签"></el-input>
      </el-form-item>
      <el-form-item label="写入方式" prop="type">
        <el-radio-group v-model="type">
          <el-radio :label="1">上传文件</el-radio>
          <el-radio :label="2">在线编写</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item>
        <el-upload
          v-if="type=='1'"
          class="upload-demo"
          drag
          ref="newupload"
          :auto-upload="false"
          :on-change="addFile"
          :before-upload="beforeUpload"
          :action="getUploadUrl()">
          <i class="el-icon-upload"></i>
          <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
          <div class="el-upload__tip" slot="tip">只能上传zip文件，且不超过500kb</div>
        </el-upload>
        <mavon-editor v-if="type=='2'" @imgAdd="imgAdd" class="mavon-editor" ref="md" v-model="blog.content" :subfield="false" :toolbars="mavonEditorToolbars"></mavon-editor>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="close()" size="medium">取 消</el-button>
      <el-button type="primary" @click="save()" size="medium">确 定</el-button>
    </div>
  </div>

</template>

<script src="./blog-add.js"></script>
<style src="./blog-add.css"></style>
