/**
 * Copyright (c) 2003-2016, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

/* exported initSample */

if ( CKEDITOR.env.ie && CKEDITOR.env.version < 9 )
	CKEDITOR.tools.enableHtml5Elements( document );

// The trick to keep the editor in the sample quite small
// unless user specified own height.
CKEDITOR.config.height = 150;
CKEDITOR.config.width = 'auto';
var initCKEditor = ( function(editorID, content) {
	var wysiwygareaAvailable = isWysiwygareaAvailable(),
		isBBCodeBuiltIn = !!CKEDITOR.plugins.get( 'bbcode' );

	return function(editorID, content) {
		var editorElement = CKEDITOR.document.getById( editorID);

		// :(((
		if ( isBBCodeBuiltIn ) {
			editorElement.setHtml(content);
		}

		// Depending on the wysiwygare plugin availability initialize classic or inline editor.
		if ( wysiwygareaAvailable ) {
			CKEDITOR.replace( editorID );
		} else {
			editorElement.setAttribute( 'contenteditable', 'true' );
			CKEDITOR.inline( editorID );

			editorElement.setHtml(content);
		}
	};

	function isWysiwygareaAvailable() {
		// If in development mode, then the wysiwygarea must be available.
		// Split REV into two strings so builder does not replace it :D.
		if ( CKEDITOR.revision == ( '%RE' + 'V%' ) ) {
			return true;
		}

		return !!CKEDITOR.plugins.get( 'wysiwygarea' );
	}
} )();

/**
 * 解决ckEditor与modal冲突
 */
$.fn.modal.Constructor.prototype.enforceFocus = function () {
	var $modalElement = this.$element;
	$(document).on('focusin.modal', function (e) {
		var $parent = $(e.target.parentNode);
		if ($modalElement[0] !== e.target && !$modalElement.has(e.target).length
			// add whatever conditions you need here:
			&&
			!$parent.hasClass('cke_dialog_ui_input_select') && !$parent.hasClass('cke_dialog_ui_input_text')) {
			$modalElement.focus()
		}
	})
};
