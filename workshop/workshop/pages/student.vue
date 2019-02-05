<template>
    <div><h1>Student List</h1>
    <ul><li v-for="st in student" :key="st.id">
        {{st.code}} - {{st.fname}} - {{st.lname}}
        </li></ul>
    </div>
</template>

<script>
export default {
  data() {
    return {
      students: []
    }
  },
  async created() {
    console.log('created')
    let res = await this.$http.get('/student')
    console.log(res.data)
  }
}
</script>