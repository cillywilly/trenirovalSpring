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
        <form method="post" action="/api/training">
            <input type="text" name="trainingTopic" placeholder="Введите название тренировки"/>
            <input type="datetime-local" name="date" placeholder="date"/>
            <input type="hidden" name="userId" value=${user.getId()}>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
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

</@c.page>