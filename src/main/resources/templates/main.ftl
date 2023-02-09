<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <h1>
        Welcome ${user.getLogin()}
    </h1>
    <div>
        <@l.logout />
    </div>

    <div>
        <form method="post" action="/api/training" <#--onsubmit="onFormSubmit()"--> enctype="application/json">
            <input type="text" id="trainingTopic" name="trainingTopic" placeholder="Введите название тренировки"/>
            <input type="datetime-local" id="date" name="date" placeholder="date"/>
            <input type="hidden" id="userId" name="userId" value=${user.getId()}>
            <input type="hidden" id="_csrf" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Добавить</button>
        </form>
    </div>

    <#list trainings as training>
        <div>
            <a href="http://localhost:8080/api/training?id=${training.getId()}">
                <b>${training.getId()}</b>
                <span>${training.date}</span>
                <i>${training.trainingTopic}</i>
                <strong>${user.getLogin()}</strong>
            </a>
        </div>
    <#else>
        No trainings
    </#list>
    <script type="text/javascript">

        function onFormSubmit(e) {
            event.preventDefault();
            var formData = readFormData();
            console.log(formData)
        }

        function readFormData() {
            var formData = {};
            formData["trainingTopic"] = document.getElementById("trainingTopic").value;
            formData["date"] = document.getElementById("date").value;
            formData["userId"] = document.getElementById("userId").value;
            formData["_csrf"] = document.getElementById("_csrf").value;
            return formData;
        }

    </script>
</@c.page>