import { Component, OnInit } from '@angular/core';
import { History, HistoryService } from '../history.service';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  imports: [CommonModule, MatTableModule],
  styleUrl: './history.component.css',
  standalone: true,
})
export class HistoryComponent implements OnInit{
  histories: any[] = []
  displayedColumns : string[] = ['timestamp', 'username', "city"]
  dataSource = new MatTableDataSource<History>(this.histories)

  constructor(private historyService : HistoryService) {}
  
  ngOnInit(): void {
    this.loadHistory()
  }

  loadHistory() {
    this.historyService.getHistory().subscribe(data => {
      data.sort(
        (a: any, b: any) => new Date(b.timestamp).getTime() - new Date(a.timestamp).getTime()
      );
      this.histories = data
      this.dataSource.data = data
    })
  }
}

