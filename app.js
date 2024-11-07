function addTask() {
    const newTask = document.getElementById("newTask").value;
    if (newTask) {
        const taskList = document.getElementById("taskList");
        const task = document.createElement("div");
        task.textContent = newTask;
        taskList.appendChild(task);
        document.getElementById("newTask").value = "";
    }
}
