import { Component, Input } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
    // tslint:disable-next-line:component-selector
    selector: 'validator-message',
    template: `
{{validatorMessages}}
  `,
})
export class ValidatorMessageComponent {
    @Input() field: FormControl;

    public get validatorMessages() {
        const field = this.field;
        if (!field || !field.errors) {
            return false;
        }
        const errors = [];
        const config = {
            required: 'Field is required',
            requiredTrue: 'Value should be positive',
            email: 'Field should contain e-mail',
            pattern: 'Field does not match to pattern',
        };
        if (field.errors.hasOwnProperty('custom')) {
            config['custom'] = (typeof field.errors.custom === 'string' && field.errors.custom.length) ?
                field.errors.custom :
                'Does not match to format';
        }
        if (field.errors.hasOwnProperty('minlength')) {
            config['minlength'] = `Minimum length ${field.errors.minlength.requiredLength}`;
        }
        if (field.errors.hasOwnProperty('maxlength')) {
            config['maxlength'] = `Maximum length ${field.errors.maxlength.requiredLength}`;
        }

        Object.keys(field.errors).forEach((error: string) => {
            errors.push(config[error]);
        });

        return errors[0];
    }

}
