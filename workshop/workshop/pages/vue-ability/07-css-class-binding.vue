<template>
  <div class="con-center">
    <h1>06.-v-for</h1>
    <br><br>
    <h1>Studen List</h1>
    <ul>
        <li v-for="st in student" :key="st.code"
        :class="{ fail: st.score < 50, good: st.score >= 80}">
        <span>{{st.code}}</span>
        <span>{{st.name}}</span>
        </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
      
    return {
      student: [
          {code: "001", name: "Name1", score:49},
          {code: "002", name: "Name2", score:60},
          {code: "003", name: "Name3", score:50},
          {code: "004", name: "Name4", score:85}
      ]
     
    };
  }
};
</script>

<style>
.con-center {
  text-align: center;
  margin-top: 1rem;
}
.fail{
  color: red;
}
.good{
  color: green;
  font-weight: bold;
}
</style>

