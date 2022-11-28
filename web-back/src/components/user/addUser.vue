<template>
    <div class="addUser">
        <div class="addMes">
            <div>
                <label for="name">用户名</label>
                <input style="width: calc(100% - 70px)" name="name" type="text" v-model="username">
            </div>
            <div>
                <label for="password">密码</label>
                <input style="width: calc(100% - 70px)" name="password" type="password" v-model="password">
            </div>
            <div>
                <label for="status">状态</label>
                <input class="radio" name="status" type="radio" value="正常" v-model="status">正常
                <input class="radio" name="status" type="radio" value="异常" v-model="status">异常
                <label for="sex">性别</label>
                <input class="radio" name="sex" type="radio" value="男" v-model="sex">男
                <input class="radio" name="sex" type="radio" value="女" v-model="sex">女
            </div>
            <div>
                <label for="country">国家</label>
                <input class="position" name="country" type="text" v-model="country">
                <label for="provience">省份</label>
                <input class="position" name="provience" type="text" v-model="provience">
                <label for="city">城市</label>
                <input class="position" name="city" type="text" v-model="city">
            </div>
            <div>
                <label for="mobel">联系方式</label>
                <input style="width: calc(100% - 70px)" name="mobel" type="text" v-model="mobel">
            </div>
            <div v-if="errorMes !== ''"></div>
            <button @click="submit">提交</button>
        </div>
    </div>
</template>

<script>
import { ref } from 'vue';
import $ from 'jquery'

export default {
    name: 'AddUser',
    props: ['changeIsAdd'],
    setup(_, context) {
        let username = ref(''), password = ref(''), sex = ref('男'), status = ref('正常'), provience = ref(''),
            country = ref(''), city = ref(''), mobel = ref(''), errorMes = ref('');
        const submit = async () => {
            $.ajax({
                url: 'http://localhost:3000/add/user',
                type: 'post',
                data: {
                    username: username.value,
                    password: password.value,
                    sex: sex.value === '男' ? false : true,
                    status: status.value === '正常' ? false : true,
                    provience: provience.value,
                    country: country.value,
                    city: city.value,
                    mobel: mobel.value,
                },
                success: (resp) => {
                    console.log(resp);
                    context.emit("changeIsAdd");
                }
            })
        }
        return {
            username,
            password,
            sex,
            status,
            provience,
            country,
            city,
            mobel,
            errorMes,
            submit
        }
    }
}

</script>

<style scoped>
.addUser {
    width: 90%;
    height: calc(100% - 64px);
    background-color: rgba(255, 255, 255, 0.486);
    display: flex;
    align-items: center;
    justify-content: center;
}

.addMes {
    width: 500px;
    height: 400px;
    background-color: whitesmoke;
    border-radius: 10px;
    box-shadow: 0px 0px 5px gray;
    padding: 10px;
}

.addMes>button {
    height: 40px;
    border-radius: 20px;
    width: 100%;
    border: 0;
    background-color: rgb(69, 112, 230);
    color: white;
}

.addMes>div {
    height: 52px;
    margin-bottom: 12px;
    display: flex;
    align-items: center;
    flex-shrink: 0;
    flex-wrap: wrap;
}

.addMes>div>label {
    width: 70px;
    display: flex;
    align-items: center;
    justify-content: center;
}

.addMes>div>input {
    height: 36px;
    /* width: calc(100% - 70px); */
    border-radius: 18px;
    border: 1px solid greenyellow;
    padding: 0 18px 0 18px;
}

.position {
    width: 80px;
}

.radio {
    width: 15px;
    height: 15px;
}
</style>