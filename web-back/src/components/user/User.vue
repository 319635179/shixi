<template>
    <div class="userTable">
        <div class="option">
            <button @click="changeIsAdd">新增</button>
            <button>导出</button>
        </div>
        <AddUser @changeIsAdd="changeIsAdd" class="addUser" v-if="isAdd === 1" />
        <div class="userTable">
            <div class="table">
                <div class="title" v-for="(title, i) in tableTitle"
                    :style="{ width: tableWidth[i], backgroundColor: 'rgb(44, 108, 160)', borderTop: '1px solid rgb(236, 206, 36)' }"
                    :key="title.id">{{ title.name }}
                </div>
            </div>
            <div class="table" v-for="(user, i) of tableMes" :key="user.id">
                <div v-for="(content, j) in user.data"
                    :style="{ width: tableWidth[j], backgroundColor: i % 2 === 0 ? 'rgb(8, 52, 88)' : 'rgb(44, 108, 160)' }"
                    :key="content.id">
                    {{ content.mes }}
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { v4 as uuidv4 } from 'uuid';
import { ref } from 'vue';
import $ from 'jquery'
import AddUser from './addUser.vue';

export default {
    name: 'UserTable',
    components: {
        AddUser
    },
    setup() {
        let isAdd = ref(0);
        const tableWidth = [
            '64px', '130px', '64px', '64px', '200px', '140px', '200px', '200px', '400px', '400px'
        ]
        const tableTitle = ref([
            { id: uuidv4, name: '序号', style: { width: tableWidth[0] } },
            { id: uuidv4, name: '名字', style: { width: tableWidth[1] } },
            { id: uuidv4, name: '状态', style: { width: tableWidth[2] } },
            { id: uuidv4, name: '性别', style: { width: tableWidth[3] } },
            { id: uuidv4, name: '地区', style: { width: tableWidth[4] } },
            { id: uuidv4, name: '联系方式', style: { width: tableWidth[5] } },
            { id: uuidv4, name: '创建时间', style: { width: tableWidth[6] } },
            { id: uuidv4, name: '修改时间', style: { width: tableWidth[7] } },
        ])

        const tableMes = ref([]);
        const getUser = () => {
            $.ajax({
                url: 'http://localhost:3000/query/user',
                type: 'get',
                success: (resp) => {
                    for (let i = 0; i < resp.data.length; i++) {
                        const data = resp.data[i];
                        const auser = [
                            { id: uuidv4, mes: resp.data.length - i, style: { width: tableWidth[0] } },
                            { id: uuidv4, mes: data.username, style: { width: tableWidth[1] } },
                            { id: uuidv4, mes: data.status ? '异常' : '正常', style: { width: tableWidth[2] } },
                            { id: uuidv4, mes: data.sex ? '女' : '男', style: { width: tableWidth[3] } },
                            { id: uuidv4, mes: data.country + data.province + data.city, style: { width: tableWidth[4] } },
                            { id: uuidv4, mes: data.mobile, style: { width: tableWidth[5] } },
                            { id: uuidv4, mes: data.createTime, style: { width: tableWidth[6] } },
                            { id: uuidv4, mes: data.updateTime, style: { width: tableWidth[7] } },
                        ]
                        tableMes.value.unshift({ id: uuidv4, data: auser });
                    }
                }
            })
        }
        getUser();

        const changeIsAdd = () => {
            tableMes.value = [];
            getUser();
            isAdd.value = 1 - isAdd.value;
        }
        return {
            tableWidth,
            tableTitle,
            tableMes,
            isAdd,
            changeIsAdd
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
}

.userTable {
    width: 96%;
    margin: 12px 2% 0 2%;
}

.table {
    color: rgb(253, 149, 30);
    width: 100%;
    height: 50px;
    display: flex;
    background-color: steelblue;
    align-items: center;
    justify-content: center;
}

.table>div {
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    border: 1px solid rgb(236, 206, 36);
    border-left: 0;
    border-top: 0;
}

.table>div:nth-child(1) {
    border-left: 1px solid rgb(236, 206, 36);
}
</style>