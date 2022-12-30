<template>
    <div class="editUser">
        <div class="editMes">
            <div>
                <label for="name">用户名</label>
                <input style="width: calc(100% - 70px)" name="name" type="text" v-model="username">
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
                <label for="province">省份</label>
                <input class="position" name="province" type="text" v-model="province">
                <label for="city">城市</label>
                <input class="position" name="city" type="text" v-model="city">
            </div>
            <div>
                <label for="mobile">联系方式</label>
                <input style="width: calc(100% - 70px)" name="mobile" type="text" v-model="mobile">
            </div>
            <div v-if="errorMes !== ''"></div>
            <button @click="submit">提交</button>
            <button @click="changeIsEdit">取消</button>
        </div>
    </div>
</template>

<script>
import { ref } from 'vue';
import $ from 'jquery'
import { useStore } from 'vuex';

export default {
    name: 'EditUser',
    props: ['userMes', 'nowId'],
    emits: ['changeIsEdit'],
    setup(props, context) {
        const store = useStore();
        let username = ref(props.userMes.data[props.userMes.data.length - props.nowId - 1].username),
            sex = ref(props.userMes.data[props.userMes.data.length - props.nowId - 1].sex ? '女' : '男'),
            status = ref(props.userMes.data[props.userMes.data.length - props.nowId - 1].status ? '异常' : '正常'),
            province = ref(props.userMes.data[props.userMes.data.length - props.nowId - 1].province),
            country = ref(props.userMes.data[props.userMes.data.length - props.nowId - 1].country),
            city = ref(props.userMes.data[props.userMes.data.length - props.nowId - 1].city),
            mobile = ref(props.userMes.data[props.userMes.data.length - props.nowId - 1].mobile), errorMes = ref('');
        const submit = () => {
            $.ajax({
                url: 'http://localhost:3000/update/user',
                type: 'post',
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                data: {
                    id: props.userMes.data[props.userMes.data.length - props.nowId - 1].id,
                    username: username.value,
                    status: status.value === '正常' ? false : true,
                    sex: sex.value === '男' ? false : true,
                    country: country.value,
                    province: province.value,
                    city: city.value,
                    mobile: mobile.value,
                },
                success: (resp) => {
                    console.log(resp);
                    context.emit("changeIsEdit");
                }
            })
        }
        const changeIsEdit = () => {
            context.emit("changeIsEdit");
        }
        return {
            username,
            sex,
            status,
            province,
            country,
            city,
            mobile,
            errorMes,
            submit,
            changeIsEdit
        }
    }
}

</script>

<style scoped>
.editUser {
    width: 90%;
    height: calc(100% - 64px);
    background-color: rgba(255, 255, 255, 0.486);
    display: flex;
    align-items: center;
    justify-content: center;
}

.editMes {
    width: 500px;
    height: 330px;
    background-color: whitesmoke;
    border-radius: 10px;
    box-shadow: 0px 0px 5px gray;
    padding: 10px;
}

.editMes>button {
    height: 40px;
    border-radius: 20px;
    width: 50%;
    border: 0;
    background-color: rgb(69, 112, 230);
    color: white;
}

.editMes>div {
    height: 52px;
    margin-bottom: 12px;
    display: flex;
    align-items: center;
    flex-shrink: 0;
    flex-wrap: wrap;
}

.editMes>div>label {
    width: 70px;
    display: flex;
    align-items: center;
    justify-content: center;
}

.editMes>div>input {
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