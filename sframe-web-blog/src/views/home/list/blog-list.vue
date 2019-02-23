<template>
  <div>
    <section>
      <transition-group name="el-zoom-in-center">
        <el-card shadow="hover" v-for="(item,index) in blogs" :key="'p'+index" style="margin-bottom: 20px" v-if="!item.hide">
          <div slot="header">
            <el-row>
              <el-col :span="16">
                            <span>
                                <a style="text-decoration:none;cursor:pointer">
                                    <i class="el-icon-edit-outline"></i>&nbsp;&nbsp; {{item.title}}
                                </a>
                            </span>
              </el-col>
              <el-col :span="8">
                <div style="text-align: right;">
                  <el-button  style="padding: 3px 0" type="text" icon="el-icon-share"></el-button>
                  <el-button style="padding: 3px 0" type="text" icon="el-icon-edit" ></el-button>
                  <el-button  style="padding: 3px 0" type="text" icon="el-icon-delete"></el-button>
                </div>
              </el-col>
            </el-row>
          </div>
          <div style="font-size: 0.9rem;line-height: 1.5;color: #606c71;">
            最近更新 {{item.updateTime}}
          </div>
          <div style="font-size: 1.1rem;line-height: 1.5;color: #303133;padding: 10px 0px 0px 0px">
            {{item.description}}
          </div>
        </el-card>
      </transition-group>
    </section>
  </div>
</template>

<script src="./blog-list.js"></script>
<style src="./blog-list.css"></style>
