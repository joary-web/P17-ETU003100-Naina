<body>
    <p>Depence</p>
    <form name="form1" method="post" action="Fromulaire.html">
    
    <p>
        Libelle : 
        <select name="Libelle">
            <% for(int a=0;a<5;a++){ "<option value=\"depence\">depence</option>" }%>
        </select>
    </p>
    <p>
        Depence : <input type="text" name="depence">
    </p>
    <input type="submit" name="Submit" rows="5" value="Soumettre">
    </form>