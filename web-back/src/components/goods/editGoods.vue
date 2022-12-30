<template>
    <div class="editGoods">
        <div class="editMes">
            <div>
                <label for="name">商品名</label>
                <input style="width: calc(100% - 70px)" name="name" type="text" v-model="Goodsname">
            </div>
            <div>
                <label for="status">状态</label>
                <input class="radio" name="status" type="radio" value="上架" v-model="status">上架
                <input class="radio" name="status" type="radio" value="下架" v-model="status">下架
            </div>
            <div>
                <label for="photo"
                    style="width: 100%; display: flex;align-items: center;justify-content: center;">商品封面</label>
                <input style="width: 100%;" name="multipartFile" type="file" @change="getPhoto">
                <img :src="'http://localhost:3000' + url" style="height: 80px; width: 80px;" alt="">
            </div>
            <div>
                <label for="tags">标签</label>
                <input style="width: calc(100% - 70px)" name="tags" type="text" v-model="tags">
            </div>
            <div>
                <label for="price">价格</label>
                <input style="width: calc(100% - 70px)" name="price" type="text" v-model="price">
            </div>
            <div>
                <label for="shopid">商店Id</label>
                <input style="width: calc(100% - 70px)" name="shopid" type="text" v-model="shopid">
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
    name: 'EditGoods',
    props: ['goodsMes', 'nowId'],
    emits: ['changeIsEdit'],
    setup(props, context) {
        const store = useStore();
        let Goodsname = ref(props.goodsMes.data[props.goodsMes.data.length - props.nowId - 1].name),
            price = ref(props.goodsMes.data[props.goodsMes.data.length - props.nowId - 1].price),
            tags = ref(props.goodsMes.data[props.goodsMes.data.length - props.nowId - 1].tags),
            shopid = ref(props.goodsMes.data[props.goodsMes.data.length - props.nowId - 1].shopid),
            status = ref(props.goodsMes.data[props.goodsMes.data.length - props.nowId - 1].status === 1 ?
                '下架' : props.goodsMes.data[props.goodsMes.data.length - props.nowId - 1].status === 2 ?
                    '上架' : ''),
            errorMes = ref('');

        let url = ref(props.goodsMes.data[props.goodsMes.data.length - props.nowId - 1].photoUrl);

        const submit = () => {
            $.ajax({
                url: 'http://localhost:3000/modify/goods',
                type: 'post',
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                data: {
                    id: props.goodsMes.data[props.goodsMes.data.length - props.nowId - 1].id,
                    Goodsname: Goodsname.value,
                    price: price.value,
                    tag: tags.value,
                    url: url.value,
                    status: status.value === '上架' ? 1 : 2,
                    shopid: shopid.value
                },
                success: (resp) => {
                    console.log(resp.error_message);
                    if (resp.error_message === 'success')
                        context.emit("changeIsEdit");
                    else errorMes.value = resp.error_message;
                }
            })
        }

        const getPhoto = (event) => {
            let multipartFile = new FormData();
            multipartFile.append('multipartFile', event.target.files[0], event.target.files[0].name);
            $.ajax({
                url: 'http://localhost:3000/add/photo',
                type: 'post',
                data: multipartFile,
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                cache: false,
                processData: false,
                contentType: false,
                success: resp => {
                    url.value = resp.photo_url;
                },
                error(resp) {
                    console.log(resp);
                }
            })
        }

        const changeIsEdit = () => {
            context.emit("changeIsEdit");
        }
        return {
            Goodsname,
            price,
            tags,
            shopid,
            status,
            errorMes,
            getPhoto,
            submit,
            changeIsEdit
        }
    }
}

</script>

<style scoped>
.editGoods {
    width: 90%;
    height: calc(100% - 64px);
    background-color: rgba(255, 255, 255, 0.486);
    display: flex;
    align-items: center;
    justify-content: center;
}

.editMes {
    width: 500px;
    height: 540px;
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
    min-height: 52px;
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