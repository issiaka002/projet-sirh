document.addEventListener('alpine:init', () => {
    // main section
    Alpine.data('scrollToTop', () => ({
        showTopButton: false,
        init() {
            window.onscroll = () => {
                this.scrollFunction();
            };
        },

        scrollFunction() {
            if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
                this.showTopButton = true;
            } else {
                this.showTopButton = false;
            }
        },

        goToTop() {
            document.body.scrollTop = 0;
            document.documentElement.scrollTop = 0;
        },
    }));

    // theme customization
    Alpine.data('customizer', () => ({
        showCustomizer: false,
    }));



    // header section
    Alpine.data('header', () => ({
        init() {
            const selector = document.querySelector('ul.horizontal-menu a[href="' + window.location.pathname + '"]');
            if (selector) {
                selector.classList.add('active');
                const ul = selector.closest('ul.sub-menu');
                if (ul) {
                    let ele = ul.closest('li.menu').querySelectorAll('.nav-link');
                    if (ele) {
                        ele = ele[0];
                        setTimeout(() => {
                            ele.classList.add('active');
                        });
                    }
                }
            }
        },

        notifications: [
            {
                id: 1,
                profile: 'user-profile.jpeg',
                message: '<strong class="text-sm mr-1">StarCode Kh</strong>invite you to <strong>Prototyping</strong>',
                time: '45 min ago',
            },

        ],
    }));
    //contacts
    Alpine.data('contacts', () => ({
        defaultParams: {
            id: null,
            nom:'',
            prenom: '',
            email: '',
            typeContrat: '',
            fonction: '',
            dateNaissance: '',
            salaire: null,
            sexe: '',
            adresse: '',
            matricule: '',
            telephone: '',
            nationnalite: '',
            status:'',
            roles: [],
            grade: null,
            domaine:'',
            cni: null
        },
        displayType: 'list',
        addContactModal: false,
        params: {
            id: null,
            nom:'',
            prenom: '',
            email: '',
            typeContrat: '',
            fonction: '',
            dateNaissance: '',
            salaire: null,
            sexe: '',
            adresse: '',
            matricule: '',
            telephone: '',
            nationnalite: '',
            status:'',
            roles: [],
            grade: null,
            domaine:'',
            cni: null
        },
        filterdContactsList: [],
        searchUser: '',
        employeList: [],
        init() {
            this.fetchEmployes();
        },
        fetchEmployes() {
            // Utiliser fetch() pour récupérer les données depuis l'API
            fetch('http://localhost:8080/enseignant')
                .then(response => response.json())
                .then(data => {
                    console.log(data);
                    // Assigner les données récupérées à employeList
                    this.employeList = data;
                    console.log("list="+this.employeList);
                    // Appeler la fonction pour initialiser la liste des employés
                    this.searchEmployes();
                })
                .catch(error => {
                    console.error('Erreur lors de la récupération des employés :', error);
                });
        },
        searchEmployes() {
            // Filtrer la liste des employés en fonction de la recherche
            this.filteredEmployesList = this.employeList.filter((employe) =>
                employe.nom.toLowerCase().includes(this.searchUser.toLowerCase()) ||
                employe.prenom.toLowerCase().includes(this.searchUser.toLowerCase())
            );
        },

        searchContacts() {
            this.filterdContactsList = this.contactList.filter((d) => d.name.toLowerCase().includes(this.searchUser.toLowerCase()));
        },

        editUser(user) {
            this.params = this.defaultParams;
            if (user) {
                this.params = JSON.parse(JSON.stringify(user));
            }

            this.addContactModal = true;
        },

        saveUser() {
            if (!this.params.name) {
                this.showMessage('Name is required.', 'error');
                return true;
            }
            if (!this.params.email) {
                this.showMessage('Email is required.', 'error');
                return true;
            }
            if (!this.params.phone) {
                this.showMessage('Phone is required.', 'error');
                return true;
            }
            if (!this.params.role) {
                this.showMessage('Occupation is required.', 'error');
                return true;
            }

            if (this.params.id) {
                //update user
                let user = this.contactList.find((d) => d.id === this.params.id);
                user.name = this.params.name;
                user.email = this.params.email;
                user.role = this.params.role;
                user.phone = this.params.phone;
                user.location = this.params.location;
            } else {
                //add user
                let maxUserId = this.contactList.length
                    ? this.contactList.reduce((max, character) => (character.id > max ? character.id : max), this.contactList[0].id)
                    : 0;

                let user = {
                    id: maxUserId + 1,
                    path: 'profile-35.png',
                    name: this.params.name,
                    email: this.params.email,
                    role: this.params.role,
                    phone: this.params.phone,
                    location: this.params.location,
                    posts: 20,
                    followers: '5K',
                    following: 500,
                };
                this.contactList.splice(0, 0, user);
                this.searchContacts();
            }

            this.showMessage('User has been saved successfully.');
            this.addContactModal = false;
        },

        deleteUser(user) {
            this.contactList = this.contactList.filter((d) => d.id != user.id);
            // this.ids = this.ids.filter((d) => d != user.id);
            this.searchContacts();
            this.showMessage('User has been deleted successfully.');
        },

        setDisplayType(type) {
            this.displayType = type;
        },

        showMessage(msg = '', type = 'success') {
            const toast = window.Swal.mixin({
                toast: true,
                position: 'top',
                showConfirmButton: false,
                timer: 3000,
            });
            toast.fire({
                icon: type,
                title: msg,
                padding: '10px 20px',
            });
        },
    }));
});
