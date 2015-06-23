
    <h1> Save new faculty </h1>

    <form action="/faculties/create" method="post">
        <p>
            Title : <input type="text" name="title"/>
        </p>

        <button type="submit" value=" Send" class="btn btn-success">
            Save new faculty
        </button>
        <a href="/faculties" class="btn btn-primary">Cancel</a>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    </form>



