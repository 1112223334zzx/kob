<template>
<h1></h1>
</template>

<script>
//1.测试登录的api
import $ from "jquery"
export default{
    components:"Test",
    setup(){
        $.ajax({
            url:"http://localhost:3000/user/account/token/",
            type:"post",
            data:{
                username:"b",
                password:"pb",
            },
            succuess(resp){
                console.log(resp);
            },
            error(resp){
                console.log(resp);
            }
        })
    }
}

</script>

<style scoped>
</style>