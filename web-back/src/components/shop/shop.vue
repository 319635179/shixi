<template>
    <div class="userTable">
        <div class="option">
            <button @click="changeIsAdd">新增</button>
            <button>导出</button>
        </div>
        <AddShop @changeIsAdd="changeIsAdd" @onlyChangeAdd="onlyChangeIsAdd" class="addUser" v-if="isAdd === 1" />
        <EditShop @changeIsEdit="changeIsEdit" :userMes="data" :nowId="nowId" class="addUser" v-if="isEdit === 1" />
        <TableMes :tableMes="tableMes" :tableTitle="tableTitle" :tableWidth="tableWidth" @editMes="editMes"
            @deleteMes="deleteMes" />
        <TableList @setPage="setPage" @setIndex="setIndex" :index="index" :page="page" :allLen="allLen" />
    </div>
</template>

<script>
import { v4 as uuidv4 } from 'uuid';
import { ref } from 'vue';
import $ from 'jquery'
import { useStore } from 'vuex';
import AddShop from './addShop.vue';
import TableList from '../tableList.vue';
import TableMes from '../tableMes.vue';
import EditShop from './editShop.vue';

export default {
    name: 'ShopTable',
    components: {
        AddShop,
        TableList,
        TableMes,
        EditShop
    },
    setup() {
        const store = useStore();
        let isAdd = ref(0);
        let nowId = ref(-1);
        let isEdit = ref(0);
        let data = ref({});
        let allLen = ref(0.0);
        let index = ref(3.0);
        let page = ref(1.0);
        let search = ref('');
        let pageItem = ref(1);
        let url = ref('http://localhost:3000/query/shop?' + 'index=' + index.value + '&page=' + page.value);
        const tableWidth = [
            '64px', '130px', '130px', '130px', '100px', '140px', '200px', '200px', '400px', '400px'
        ]
        const tableTitle = ref([
            { id: uuidv4, name: '序号', style: { width: tableWidth[0] } },
            { id: uuidv4, name: '名字', style: { width: tableWidth[1] } },
            { id: uuidv4, name: '地区', style: { width: tableWidth[2] } },
            { id: uuidv4, name: '分类', style: { width: tableWidth[3] } },
            { id: uuidv4, name: '联系人', style: { width: tableWidth[4] } },
            { id: uuidv4, name: '联系方式', style: { width: tableWidth[5] } },
            { id: uuidv4, name: '创建时间', style: { width: tableWidth[6] } },
            { id: uuidv4, name: '修改时间', style: { width: tableWidth[7] } },
        ])
        const tableMes = ref([]);
        const getAllLen = () => {
            $.ajax({
                url: 'http://localhost:3000/query/shop',
                type: 'get',
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success: (resp) => {
                    allLen.value = resp.data.length;
                }
            })
        }
        getAllLen();

        const getUser = () => {
            tableMes.value = [];
            $.ajax({
                url: url.value,
                type: 'get',
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                success: (resp) => {
                    data.value = resp;
                    for (let i = 0; i < resp.data.length; i++) {
                        const data = resp.data[i];
                        const shopId = resp.data[i].id;
                        const cT = new Date(data.createTime);
                        const uT = new Date(data.updateTime);
                        data.createTime = cT.getFullYear() + '-' + (cT.getMonth() + 1) + '-' + cT.getDate() + ' ' + cT.getHours() + ':' + cT.getMinutes() + ':' + cT.getSeconds();
                        data.updateTime = uT.getFullYear() + '-' + (uT.getMonth() + 1) + '-' + uT.getDate() + ' ' + uT.getHours() + ':' + uT.getMinutes() + ':' + uT.getSeconds();
                        const auser = [
                            { id: uuidv4, mes: resp.data.length - i + (page.value - 1) * index.value, style: { width: tableWidth[0] } },
                            { id: uuidv4, mes: data.shopName, style: { width: tableWidth[1] } },
                            { id: uuidv4, mes: data.provideArea, style: { width: tableWidth[2] } },
                            { id: uuidv4, mes: data.goodsClass, style: { width: tableWidth[3] } },
                            { id: uuidv4, mes: data.liaisonName, style: { width: tableWidth[4] } },
                            { id: uuidv4, mes: data.liaisonMoble, style: { width: tableWidth[5] } },
                            { id: uuidv4, mes: data.createTime, style: { width: tableWidth[6] } },
                            { id: uuidv4, mes: data.updateTime, style: { width: tableWidth[7] } },
                        ]
                        tableMes.value.unshift({ id: uuidv4, shopId, data: auser });
                    }
                }
            })
        }
        getUser();
        const changeIsAdd = () => {
            getUser();
            isAdd.value = 1 - isAdd.value;
            getAllLen();
        }

        const editMes = (i) => {
            nowId.value = i;
            isEdit.value = 1 - isEdit.value;
        }

        const deleteMes = (i) => {
            $.ajax({
                url: 'http://localhost:3000/delete/shop',
                type: 'post',
                headers: {
                    Authorization: "Bearer " + store.state.user.token,
                },
                data: {
                    id: tableMes.value[i].shopId,
                },
                success: (resp) => {
                    console.log(resp);
                    getUser();
                }
            })
        }

        const onlyChangeIsAdd = () => {
            isAdd.value = 1 - isAdd.value;
        }

        const changeIsEdit = () => {
            isEdit.value = 1 - isEdit.value
            getUser();
        }

        const setIndex = (i) => {
            index.value = i;
            url.value = 'http://localhost:3000/query/shop?' + 'index=' + index.value + '&page=' + page.value;
            setPage(1);
        }

        const setPage = (i) => {
            page.value = i;
            url.value = 'http://localhost:3000/query/shop?' + 'index=' + index.value + '&page=' + page.value;
            getUser();
        }

        return {
            tableWidth,
            tableTitle,
            tableMes,
            isAdd,
            isEdit,
            nowId,
            data,
            allLen,
            index,
            page,
            search,
            pageItem,
            changeIsAdd,
            onlyChangeIsAdd,
            editMes,
            changeIsEdit,
            setIndex,
            setPage,
            deleteMes
        }
    }
}

</script>

<style scoped>
.option {
    height: 50px;
    width: 94%;
    margin: 10px 3% 0 3%;
    display: flex;
    align-items: center;
    justify-content: center;
}

.option>button {
    height: 40px;
    width: 80px;
    font-size: 16px;
    border: 0;
    border-radius: 5px;
    background-color: green;
    margin: 0 10px 0 10px;
    color: rgba(240, 169, 63, 0.966);
}

.addUser {
    position: absolute;
    top: 64px;
    left: calc(10%);
    z-index: 1;
}
</style>