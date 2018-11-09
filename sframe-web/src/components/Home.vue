<template>
  <div class="home">
    home
  </div>
</template>
<script>
  export default {
    data(){
      return {
        flage: false,
        value2: 0,
        homeArticle: [],
        bannerList:[]
      }
    },
    mounted(){
      this.getHomeArticle();
      this.getBanner();
    },
    watch: {
      '$route' : ['getHomeArticle']
    },
    methods: {
      getBanner(){
        this.axios({
          method: 'get',
          url: '/public/banners'
        }).then(function (response) {
          this.bannerList = response.data;
        }.bind(this)).catch(function (error) {
          this.$Message.error('无权限');
        }.bind(this));
      },
      getHomeArticle(){
        if(this.$route.params.title == null){
          this.axios({
            method: 'get',
            url: '/public/interests'
          }).then(function (response) {
            this.homeArticle = response.data;
          }.bind(this)).catch(function (error) {
            this.$Message.error('无权限');
          }.bind(this));
        }else{
          this.axios({
            method: 'get',
            url: '/public/interests',
            params:{
              "title":this.$route.params.title
            }
          }).then(function (response) {
            this.homeArticle = response.data;
            if(this.homeArticle.length == 0){
              this.flage = true;
            }else{
              this.flage = false;
            }
            // if (this.homeArticle.length() {
            //     this.flage = true;
            // }
          }.bind(this)).catch(function (error) {
            this.$Message.error('无权限');
          }.bind(this));
        }

      },
      // login(formLogin){
      //     this.$refs[formLogin].validate((valid) => {
      //         if(valid){
      //             this.$store.dispatch('users/userLogin',{"user_name":this.formLogin.userName,"user_password":this.formLogin.password,"router":this.$router});
      //         }
      //     })
      // }
    }
  };
</script>
<style >
  .box-flex .imgpic {
    transition: .7s all;
    opacity: 0.8;
  }
  .box-flex .imgpic:hover { opacity: 1; box-shadow: 1px 1px 20px #333;
    transform:scale(1.1,1.1);cursor: pointer; }
  .lineThrou{transition: .8s all;}
  .lineThrou:hover{text-decoration:line-through;cursor: pointer}

</style>
