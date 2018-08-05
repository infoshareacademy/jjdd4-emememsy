<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/main">Menu główne<span class="sr-only">(current)</span></a>
            </li>
            <#--------------Replased by dropdown menu with email item-------->
            <#--<li class="nav-item">-->
                <#--<a class="nav-link" href="/progress">Mój postęp</a>-->
            <#--</li>-->
            <#--------------------------------------------------------------->

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    Statystyki
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/progress">Postęp</a>
                    <a class="dropdown-item" href="/mail-report">Wyslij raport</a>
                </div>
            </li>


            <li class="nav-item">
                <a class="nav-link" href="/management">Ustawienia</a>
            </li>


            <!-- Dropdown -->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    Tryby nauki
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/choose-category?mode=browse-mode">Przeglądanie</a>
                    <a class="dropdown-item" href="/choose-category?mode=learn-mode">Nauka</a>
                    <a class="dropdown-item" href="/choose-category?mode=repeat-mode">Powtórki</a>
                </div>
            </li>
            <li>
                <a class="nav-link" href="https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://emememsy.jjdd4.is-academy.pl/logout">Wyloguj</a>
            </li>
        </ul>
    </div>
</nav>

