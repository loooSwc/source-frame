<template id="sfMenu">
  <nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
      <ul class="nav" id="side-menu">
        <li class="nav-header">

          <div class="dropdown profile-element"> <span>
            <img alt="image" class="img-circle" src="img/profile_small.jpg" />
          </span>
            <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
              <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">Beaut-zihan</strong>
              </span> <span class="text-muted text-xs block">超级管理员 <b class="caret"></b></span> </span>
            </a>
            <ul class="dropdown-menu animated fadeInRight m-t-xs">
              <li><a href="form_avatar.html">修改头像</a>
              </li>
              <li><a href="profile.html">个人资料</a>
              </li>
              <li><a href="contacts.html">联系我们</a>
              </li>
              <li><a href="mailbox.html">信箱</a>
              </li>
              <li class="divider"></li>
              <li><a href="login.html">安全退出</a>
              </li>
            </ul>
          </div>
          <div class="logo-element">
            H+
          </div>

        </li>
        <li class="active">
          <a v-on:click="isShow = !isShow"><i class="fa fa-th-large"></i> <span class="nav-label">主页</span> <span class="fa arrow"></span></a>
          <transition name="fade">
            <ul class="nav nav-second-level" v-show="isShow">
              <li><a href="index_1.html">主页示例一</a>
              </li>
              <li><a href="index_2.html">主页示例二</a>
              </li>
              <li><a href="index_3.html">主页示例三</a>
              </li>
              <li><a href="index_4.html">主页示例四</a>
              </li>
            </ul>
          </transition>

        </li>
        <li>
          <a><i class="fa fa-columns"></i> <span class="nav-label">布局</span><span class="label label-danger pull-right">2.0</span></a>
        </li>
        <li>
          <a><i class="fa fa fa-globe"></i> <span class="nav-label">v2.0新增</span><span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li><a href="toastr_notifications.html">Toastr通知</a>
            </li>
            <li><a href="nestable_list.html">嵌套列表</a>
            </li>
            <li><a href="timeline_v2.html">时间轴</a>
            </li>
            <li><a href="forum_main.html">论坛</a>
            </li>
            <li><a href="code_editor.html">代码编辑器</a>
            </li>
            <li><a href="modal_window.html">模态窗口</a>
            </li>
            <li><a href="validation.html">表单验证</a>
            </li>
            <li><a href="tree_view_v2.html">树形视图</a>
            </li>
            <li><a href="chat_view.html">聊天窗口</a>
            </li>
          </ul>
        </li>
        <li>
          <a><i class="fa fa-bar-chart-o"></i> <span class="nav-label">图表</span><span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li><a href="graph_echarts.html">百度ECharts</a>
            </li>
            <li><a href="graph_flot.html">Flot</a>
            </li>
            <li><a href="graph_morris.html">Morris.js</a>
            </li>
            <li><a href="graph_rickshaw.html">Rickshaw</a>
            </li>
            <li><a href="graph_peity.html">Peity</a>
            </li>
            <li><a href="graph_sparkline.html">Sparkline</a>
            </li>
          </ul>
        </li>
        <li>
          <a><i class="fa fa-envelope"></i> <span class="nav-label">信箱 </span><span class="label label-warning pull-right">16</span></a>
          <ul class="nav nav-second-level">
            <li><a href="mailbox.html">收件箱</a>
            </li>
            <li><a href="mail_detail.html">查看邮件</a>
            </li>
            <li><a href="mail_compose.html">写信</a>
            </li>
          </ul>
        </li>
      </ul>

    </div>
  </nav>
</template>
<style>
  .fade-enter-active, .fade-leave-active {
    transition: opacity 0.25s ease-out;
  }

  .fade-enter, .fade-leave-to {
    opacity: 0;
  }
</style>
<script>
	export default {
		data() {
			return {
			  msg: '这个是menu模板页',
        isShow: true
			}
		}
	}
</script>
