<template>
  <NavBar></NavBar>
  <TestApi></TestApi>
  <router-view></router-view>
</template>

<script>
import NavBar from "./components/NavBar.vue"
import TestApi from "./components/TestApi.vue"
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap"
/* import $ from "jquery" */
export default {
  name: 'App',
  components: {
    NavBar,
    TestApi,
  },
  setup(){
/*         $.ajax({
            url:"http://localhost:3000/user/account/token/",
            type:"post",
            data:{
                username:"b",
                password:"pb",
            },
            success(resp){
                console.log(resp);
            },
            error(resp){
                console.log(resp);
            }
        }),
        $.ajax({
          url:"http://localhost:3000/user/account/info/",
          type:"get",
          headers:{
            Authorization:"Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJlZTUzODczZmVhMTY0MGQwYjE1MWY5ZDg3OGI0MDBiNyIsInN1YiI6IjMiLCJpc3MiOiJzZyIsImlhdCI6MTY5MjM2Njc0NSwiZXhwIjoxNjkzNTc2MzQ1fQ.CAIFP0mDCDm2s4-vbmvlkahF5vtSuJkbTeK6F_8bd14",
          },
          success(resp){
            console.log(resp);
          },
          error(resp){
            console.log(resp);
          }
        }),

        $.ajax({
          url:"http://localhost:3000/user/account/register/",
          type:"post",
          data:{
            username:"2",
            password:"2",
            confirmedPassword:"2",
          },
          success(resp){
            console.log(resp);
          }
        }) */
    }


}
</script>

<style>
body {
  background-image: url("@/assets/image/background.png");
  background-size: cover;
}
</style>
