import axios from "../../../axios/axios";

export default {
  data() {
    return {
      blog: {
        title: '',
        tags:'',
        content: ''
      },
      type: 1,
      mavonEditorToolbars: {
        bold: true,
        italic: true,
        header: true,
        underline: true,
        strikethrough: true,
        mark: true,
        superscript: true,
        subscript: true,
        quote: true,
        ol: true,
        ul: true,
        link: true,
        imagelink: true,
        code: true,
        table: true,
        htmlcode: true,
        trash: true,
        alignleft: true,
        aligncenter: true,
        alignright: true,
        preview: true,
      }
    }
  }, methods: {
    close(){
      this.$router.push({path:'/home/business/blog/list'})
    },
    save(){
      this.$refs.newupload.submit();
    },
    addFile(file,fileList){
      this.fileList = fileList;
      //限制上传文件为5M
      var sizeIsSatisfy = file.size < 5*1024*1024 ? true:false;
      if(sizeIsSatisfy){
        return true;
      }else{
        this.fileSizeIsSatisfy = false;
        return false;
      }
    },
    imgAdd(pos, file) {
      this.$refs.md.$img2Url(pos, file.miniurl)
    },
    getUploadUrl(){
      return '/api/admin/blog/uploadBlogFile.do';
    },
    beforeUpload(file){
      alert("before");
      let fd = new FormData();
      fd.append('file',file);//传文件
      // axios.post('/api/admin/blog/uploadBlogFile.do',fd).then(function(res){
      //   alert('成功');
      // })
    }
  }, mounted: function () {

  }
};
