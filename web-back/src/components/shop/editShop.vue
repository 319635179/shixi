<template>
    <div class="editUser">
        <div class="editMes">
            <div>
                <label for="shopName">商店名</label>
                <input style="width: calc(100% - 70px)" name="shopName" type="text" v-model="shopName">
            </div>
            <div>
                <label for="classify">分类</label>
                <input style="width: calc(100% - 70px)" name="classify" type="text" v-model="classify">
            </div>
            <div>
                <label for="area">地区</label>
                <input style="width: calc(100% - 70px)" name="area" type="text" v-model="area">
            </div>
            <div>
                <label for="liaisonName">联系人</label>
                <input style="width: calc(100% - 70px)" name="liaisonName" type="text" v-model="liaisonName">
            </div>
            <div>
                <label for="liaisonMoble">联系方式</label>
                <input style="width: calc(100% - 70px)" name="liaisonMoble" type="text" v-model="liaisonMoble">
            </div>
            <div>
                <label for="otherConnect">其他联系方式</label>
                <input style="width: calc(100% - 70px)" name="otherConnect" type="text" v-model="otherConnect">
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
    name: 'EditShop',
    props: ['userMes', 'nowId'],
    emits: ['changeIsEdit'],
    setup(props, context) {
        const store = useStore();
        let shopName = ref(props.userMes.data[props.userMes.data.length - props.nowId - 1].shopName),
            classify = ref(props.userMes.data[props.userMes.data.length - props.nowId - 1].goodsClass),
            area = ref(props.userMes.data[props.userMes.data.length - props.nowId - 1].provideArea),
            liaisonName = ref(props.userMes.data[props.userMes.data.length - props.nowId - 1].liaisonName),
            liaisonMoble = ref(props.userMes.data[props.userMes.data.length - props.nowId - 1].liaisonMoble),
            otherConnect = ref(props.userMes.data[props.userMes.data.length - props.nowId - 1].otherConnect), errorMes = ref('');

        const submit = () => {
            $.ajax({
                url: 'http://localhost:3000/modify/shop',
                type: 'post',
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                data: {
                    id: props.userMes.data[props.userMes.data.length - props.nowId - 1].id,
                    shopName: shopName.value,
                    goodsClass: classify.value,
                    provideArea: area.value,
                    liaisonName: liaisonName.value,
                    liaisonMoble: liaisonMoble.value,
                    otherConnect: otherConnect.value,
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
            shopName,
            classify,
            area,
            liaisonName,
            liaisonMoble,
            otherConnect,
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