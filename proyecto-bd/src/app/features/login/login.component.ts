import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
    selector: 'app-login',
    standalone: true,
    imports: [CommonModule, FormsModule],
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent {
    username = '';
    password = '';
    errorMessage = '';

    constructor(private authService: AuthService, private router: Router) { }

    login() {
        this.authService.login(this.username, this.password).subscribe({
            next: (user) => {
                console.log('Login successful', user);
                this.router.navigate(['/search']);
            },
            error: (err) => {
                console.error('Login failed', err);
                this.errorMessage = 'Credenciales inválidas';
            }
        });
    }
}
