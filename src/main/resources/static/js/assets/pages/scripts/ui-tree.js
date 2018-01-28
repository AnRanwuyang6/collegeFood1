var UITree = function () {

    var ajaxTreeSample = function(type) {
        $("#tree_4").jstree({
            "core": {
                "themes": {
                    "responsive": false
                },
                'data': {
                    'url': function (node) {
                        return '/admin/listAllPermission';
                    },
                    'data': function (node) {
                        return {'parent': node.id, 'roleId': $("#roleId").val(), 'type': type, 'userId': $("#userId").val()};
                    }
                }
            },
            "types": {
                "default": {
                    "icon": "fa fa-folder icon-state-warning icon-lg"
                },
                "file": {
                    "icon": "fa fa-file icon-state-warning icon-lg"
                }
            },
            "plugins": ["checkbox", "types"]
        });
    };

    var ajaxTreeSample5 = function(type) {
        $("#tree_5").jstree({
            "core": {
                "themes": {
                    "responsive": false
                },
                'data': {
                    'url': function (node) {
                        return '/admin/listAllPermission';
                    },
                    'data': function (node) {
                        return {'parent': node.id, 'roleId': $("#roleId").val(), 'type': type, 'userId': $("#userId").val()};
                    }
                }
            },
            "types": {
                "default": {
                    "icon": "fa fa-folder icon-state-warning icon-lg"
                },
                "file": {
                    "icon": "fa fa-file icon-state-warning icon-lg"
                }
            },
            "plugins": ["checkbox", "types"]
        });
    };

    var ajaxTreeSample6 = function(type){
        $('#tree_6').jstree({
            "core": {
                "themes": {
                    "responsive": false
                },
                'data': {
                    'url': function (node) {
                        return '/admin/languageChannel';
                    },
                    'data': function (node) {
                        return {'parent': node.id, 'type':type, 'roleId': $("#roleId").val(), 'userId': $("#userId").val()};
                    }
                }
            },
            "types": {
                "default": {
                    "icon": "fa fa-folder icon-state-warning icon-lg"
                },
                "file": {
                    "icon": "fa fa-file icon-state-warning icon-lg"
                }
            },
            "plugins": ["checkbox", "types"]
        })
    }

    return {
        //main function to initiate the module
        init: function (type) {
            ajaxTreeSample(type);
        },
        //main function to initiate the module
        init5: function (type) {
            ajaxTreeSample5(type);
        },
        init6: function(type){
            ajaxTreeSample6(type)
        }
    };

}();

if (App.isAngularJsApp() === false) {
    jQuery(document).ready(function() {
        // UITree.init();
    });
}