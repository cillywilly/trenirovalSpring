<#import "parts/common.ftl" as c>

<@c.page>

    <div>
        <form method="post" action="/api/approach">
            <input type="text" name="trainingTopic" placeholder="Введите название упражнения"/>
            <input type="number" name="approach_number" placeholder="введите номер подхода"/>
            <input type="number" name="workload" placeholder="введите нагрузку в кг"/>
            <input type="number" name="repetitions_number" placeholder="введите количество повторений"/>
            <input type="hidden" name="userId" value=${user.getId()}>
            <input type="hidden" name="trainingId" value=${training.getId()}>

            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Добавить</button>
        </form>
    </div>

    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">First</th>
            <th scope="col">Last</th>
            <th scope="col">Handle</th>
        </tr>
        </thead>
        <tbody>
        <#list approaches as approach>
            <div>
                <tr>
                    <th scope="row">${approach?counter}</th>
                    <td>approach.</td>
                    <td>approach.</td>
                    <td>approach.</td>
                    <td>approach.</td>
                    <td>approach.</td>
                </tr>
            </div>
        <#else>
            No exercises/approaches
        </#list>
        </tbody>
    </table>

</@c.page>