<template>
    <div class="userRegister">
        <div class="RegisterItem">
            <form>
                <div class="RegisterForm">
                    <label for="username" class="form-label">用户名</label>
                    <input type="text" class="form-control" id="username" v-model="username" placeholder="请输入用户名">
                </div>
                <div class="RegisterForm">
                    <label for="password" class="form-label">密码</label>
                    <input type="password" class="form-control" id="password" v-model="password" placeholder="请输入密码名">
                </div>
                <div class="RegisterForm">
                    <label for="repassword" class="form-label">重复密码</label>
                    <input type="repassword" class="form-control" id="repassword" v-model="repassword"
                        placeholder="请输入密码名">
                </div>
                <div class="RegisterForm-sex">
                    <label for="sex">性别</label>
                    <input class="radio" name="sex" type="radio" value="男" v-model="sex">男
                    <input class="radio" name="sex" type="radio" value="女" v-model="sex">女
                </div>
                <div class="RegisterForm">
                    <label for="country">国家</label>
                    <input class="position" name="country" type="text" v-model="country">
                </div>
                <div class="RegisterForm">
                    <label for="province">省份</label>
                    <input class="position" name="province" type="text" v-model="province">
                </div>
                <div class="RegisterForm">
                    <label for="city">城市</label>
                    <input class="position" name="city" type="text" v-model="city">
                </div>
                <div class="RegisterForm">
                    <label for="mobile">联系方式</label>
                    <input name="mobile" type="text" v-model="mobile">
                </div>
                <!-- <div class="error_mes" v-if="error_mes !== ''" :style="errorMesStyle">{{ error_mes }}!</div> -->
                <button type="button" @click="Register">登录</button>
            </form>
            <div class="userAgree">登录即代表您同意本网站用户协议
            </div>
        </div>
    </div>
</template>

<script>
import { ref } from 'vue';
import $ from 'jquery';
import router from '@/router';

export default {
    name: 'RegisterView',
    setup() {
        let username = ref(''), password = ref(''), repassword = ref(''),
            sex = ref('男'), province = ref(''),
            country = ref(''), city = ref(''), mobile = ref('');
        const Register = () => {
            $.ajax({
                url: 'http://localhost:3000/user/register',
                type: 'post',
                data: {
                    username: username.value,
                    password: password.value,
                    confirmedPassword: repassword.value,
                    sex: sex.value,
                    province: province.value,
                    country: country.value,
                    city: city.value,
                    mobile: mobile.value
                },
                success: (resp) => {
                    if (resp.error_message === 'success') {
                        router.push({ name: 'Login' });
                    }
                },
                error(resp) {
                    console.log(resp);
                }
            })
        }
        return {
            username,
            password,
            repassword,
            sex,
            province,
            country,
            city,
            mobile,
            Register
        }
    }
}

</script>

<style scoped>
.userRegister {
    width: 100%;
    height: 100vh;
    min-width: 1440px;
    background-color: whitesmoke;
}

.userAgree {
    position: absolute;
    transform: translateY(290px);
    width: 180px;
    height: 20px;
    font-size: 12px;
}

.RegisterItem {
    width: 400px;
    height: 600px;
    background-color: white;
    border-radius: 10px;
}

.RegisterForm-sex>.RegisterItem>form>div>label,
.userRegister,
.RegisterItem {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
    flex-shrink: 0;
}

.RegisterItem>form {
    transform: translateY(-13px);
}

.RegisterItem>form>.RegisterForm,
.RegisterForm-sex {
    display: flex;
    align-items: center;
    height: 60px;
}

.RegisterItem>form>.RegisterForm>label,
.RegisterForm-sex>label {
    width: 80px;
}

.RegisterItem>form>.RegisterForm>input {
    height: 30px;
    width: 160px;
    border: 1px solid lightblue;
    border-radius: 5px;
}

.RegisterForm-sex>.radio {
    width: 15px;
    height: 15px;
}

.RegisterItem>form>.RegisterForm>input:focus {
    background-color: aliceblue;
    border: 1px solid blue;
}

.RegisterItem>form>button {
    width: 100%;
    height: 36px;
    margin-top: 10px;
    border: 0;
    border-radius: 18px;
    background-color: lightskyblue;
    transition: 200ms;
}

.RegisterItem>form>button:hover {
    background-color: lightsteelblue;
}

.error_mes {
    width: 100%;
    height: 20px;
    line-height: 20px;
    font-size: 12px;
    background-color: rgb(233, 157, 157);
    color: rgb(150, 0, 0);
    padding: 0 8px;
    box-sizing: border-box;
    border-radius: 10px;
    overflow: hidden;
    transition: 200ms;
    text-align: center;
}
</style>